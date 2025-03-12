package Map;

import java.util.*;
import java.util.stream.Collectors;

public class XHashMap<K, V> implements XMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;

    private int size;
    private double loadFactor;
    private Entry<K, V>[] hashTable;

    public XHashMap() {
        this.size = 0;
        this.loadFactor = 0;
        this.hashTable = new Entry[DEFAULT_CAPACITY];
    }

    private int hash(K key) {
        if(key == null)
            return 0;

        return Math.abs(key.hashCode()) % hashTable.length;
    }

    private void checkLoadFactor() {
        if(loadFactor > 0.75) {
            hashTable = Arrays.copyOf(hashTable, hashTable.length * 2);
        }
        loadFactor = (double) size / hashTable.length;
    }

    @Override
    public void put(K key, V value) {
        if(key == null || value == null) {
            throw new IllegalArgumentException();
        }

        int index = hash(key);
        Entry<K, V> entry = new Entry<>(key, value);

        if(hashTable[index] == null) {
            hashTable[index] = entry;
        } else {
            Entry<K, V> current = hashTable[index];
            while(current.next != null) {
                if(current.getKey() == key) {
                    current.setValue(value);
                    return;
                }
                current = current.next;
            }
            current.next = entry;
        }
        size++;
        checkLoadFactor();
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> current = hashTable[index];

        while(current != null) {
            if(current.getKey() == key) {
                return current.getValue();
            }
            current = current.next;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean containsKey(K key) {
        int index = hash(key);
        Entry<K, V> current = hashTable[index];

        while(current != null) {
            if(current.getKey() == key) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (Entry<K, V> current : hashTable) {
            while(current != null) {
                if(current.getValue() == value) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public V remove(K key) {
        if(!containsKey(key)) {
            throw new IllegalArgumentException();
        }

        V result = null;

        int index = hash(key);
        Entry<K, V> current = hashTable[index];

        if(current.getKey() == key) {
            result = current.getValue();
            hashTable[index] = null;
        }
        else {
            while(current.next != null) {
                if(current.next.getKey() == key) {
                    result = current.next.getValue();
                    current.next = current.next.next;
                }
                current = current.next;
            }
        }
        size--;
        return result;
    }

    @Override
    public void clear() {
        Arrays.fill(hashTable, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<K> keySet() {
        return Arrays.stream(hashTable)
                .filter(Objects::nonNull)
                .flatMap(entry -> {
                    List<K> keys = new ArrayList<>();
                    while (entry != null) {
                        keys.add(entry.getKey());
                        entry = entry.next;
                    }
                    return keys.stream();
                })
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<V> values() {
        return Arrays.stream(hashTable)
                .filter(Objects::nonNull)
                .flatMap(entry -> {
                    List<V> values = new ArrayList<>();
                    while (entry != null) {
                        values.add(entry.getValue());
                        entry = entry.next;
                    }
                    return values.stream();
                })
                .collect(Collectors.toUnmodifiableSet());
    }
}
