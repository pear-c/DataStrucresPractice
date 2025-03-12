package Map;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

class Entry<K, V> {
    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class XArrayMap<K, V> implements XMap<K, V> {
    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private Entry<K, V>[] entry;

    public XArrayMap() {
        this.size = 0;
        entry = new Entry[DEFAULT_CAPACITY];
    }

    private void resize() {
        int oldCapacity = entry.length;

        if(size == oldCapacity) {
            entry = Arrays.copyOf(entry, oldCapacity * 2);
        }
    }

    @Override
    public void put(K key, V value) {
        if(key == null || value == null) {
            throw new IllegalArgumentException();
        }

        if(entry.length == size) {
            resize();
        }

        Entry<K, V> map = new Entry<>(key, value);
        entry[size++] = map;
    }

    @Override
    public V get(K key) {
        if(!containsKey(key)) {
            throw new IllegalArgumentException();
        }
        for(int i=0; i<size; i++) {
            if(entry[i].key == key) {
                return entry[i].value;
            }
        }
        throw new NullPointerException();
    }

    @Override
    public boolean containsKey(K key) {
        for(int i=0; i<size; i++) {
            if(entry[i].key == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for(int i=0; i<size; i++) {
            if(entry[i].value == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V remove(K key) {
        int index = -1;
        V value = null;

        for(int i=0; i<size; i++) {
            if(entry[i].key == key) {
                index = i;
                value = entry[i].value;
            }
        }
        if(index < 0 || value == null) {
            throw new IllegalArgumentException();
        }

        for(int i=index; i<size; i++) {
            entry[i] = entry[i+1];
        }
        size--;

        return value;
    }

    @Override
    public void clear() {
        Arrays.fill(entry, null);
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
        return Arrays.stream(entry)
                .filter(Objects::nonNull)
                .map(e -> e.key)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<V> values() {
        return Arrays.stream(entry)
                .filter(Objects::nonNull)
                .map(e -> e.value)
                .collect(Collectors.toUnmodifiableSet());
    }
}
