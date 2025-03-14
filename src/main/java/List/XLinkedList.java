package List;

import java.util.Comparator;
import java.util.List;

public class XLinkedList<T> implements XList<T> {
    class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size;

    public XLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private Node<T> getNode(int index) {
        checkIndexOfBounds(index);

        Node<T> current = head;
        for(int i=0; i<index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void add(T element) {
        requireNotNull(element);

        if(head == null) {
            head = new Node<>(element);
        } else {
            Node<T> current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(element);
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        requireNotNull(element);
        checkIndexOfBounds(index);

        if(index == 0) {
            Node<T> newNode = new Node<>(element);
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> prev = getNode(index - 1);
            Node<T> newNode = new Node<>(element);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndexOfBounds(index);

        T removedData;
        if(index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node<T> prev = getNode(index - 1);
            removedData = prev.next.data;
            prev.next = prev.next.next;
        }
        size--;
        return removedData;
    }

    @Override
    public boolean remove(T element) {
        requireNotNull(element);

        int index = indexOf(element);
        if(index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public boolean contains(T element) {
        for(int i=0; i<size; i++) {
            if(indexOf(element) != -1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        for(int i = 0; i < size; i++) {
            if(element.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public void set(int index, T element) {
        checkIndexOfBounds(index);
        requireNotNull(element);

        getNode(index).data = element;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if(size < 2) return;

        Node<T> sorted = null;
        Node<T> current = head;

        while(current != null) {
            Node<T> next = current.next;
            sorted = sortedInsert(sorted, current, comparator);
            current = next;
        }

        head = sorted;
    }
    private Node<T> sortedInsert(Node<T> sorted, Node<T> newNode, Comparator<? super T> comparator) {
        if(sorted == null || comparator.compare(newNode.data, sorted.data) <= 0) {
            newNode.next = sorted;
            return newNode;
        }

        Node<T> current = sorted;
        while (current.next != null && comparator.compare(newNode.data, current.next.data) > 0) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        return sorted;
    }


    @Override
    public XList<T> subList(int fromIndex, int toIndex) {
        if(fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }

        XList<T> result = new XLinkedList<T>();
        for(int i = fromIndex; i < toIndex; i++) {
            result.add(get(i));
        }

        return result;
    }

    @Override
    public void addAll(List<T> otherList) {
        for(T element : otherList) {
            if(element == null) {
                throw new NullPointerException();
            }
            add(element);
        }
    }

    @Override
    public void forEach() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public XList<T> copy() {
        XList<T> result = new XLinkedList<T>();
        for(int i = 0; i < size; i++) {
            result.add(get(i));
        }
        return result;
    }

    private void checkIndexOfBounds(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    private void requireNotNull(T element) {
        if(element == null) {
            throw new NullPointerException("Element cannot be null");
        }
    }
}
