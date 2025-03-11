package List;

import java.util.Comparator;
import java.util.List;

public class XLinkedList<T> implements XList<T> {
    private Node head;
    private int size;

    public XLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(T element) {
        if(element == null) {
            throw new NullPointerException();
        }
        Node newNode = new Node(element);
        if(head == null) {
            head = newNode;
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(element == null) {
            throw new NullPointerException();
        }
        Node newNode = new Node(element);
        Node current = head;
        if(index == 0) {
            head = newNode;
        } else {
            for(int i = 1; i < index; i++) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = newNode;
            newNode.next = temp;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        Node removed = null;
        if(index == 0) {
            removed = current;
            head = current.next;
        } else {
            for(int i = 1; i < index; i++) {
                current = current.next;
            }
            removed = current.next;
            current.next = current.next.next;
        }
        size--;
        return (T) removed.getData();
    }

    @Override
    public boolean remove(T element) {
        if(element == null) {
            throw new NullPointerException();
        }
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
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return (T) current.getData();
    }

    @Override
    public void set(int index, T element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(element == null) {
            throw new NullPointerException();
        }
        Node newNode = new Node(element);
        Node current = head;
        if(index == 0) {
            newNode.next = current;
            head = newNode;
        } else {
            for(int i=1; i<index; i++) {
                current = current.next;
            }
            Node temp = current.next.next;
            current.next = newNode;
            newNode.next = temp;
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if(size <= 1) return;

        Node newNode = null;
        Node current = head;
        for(int i=1; i<size; i++) {
            Object key = get(i);
            for(int j=i-1; j>=0; j--) {
                if(comparator.compare((T)key, get(j)) < 0) {
                    Object temp = remove(j);
                    set(j, (T)key);
                    set(i, (T)temp);
                }
            }
        }
    }

    @Override
    public XList<T> subList(int fromIndex, int toIndex) {
        XList<T> result = new XLinkedList<T>();

        if(fromIndex < 0 || toIndex > size) {
            throw new IndexOutOfBoundsException();
        }

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
    }

    @Override
    public XList<T> copy() {
        XList<T> result = new XLinkedList<T>();
        for(int i = 0; i < size; i++) {
            result.add(get(i));
        }
        return result;
    }


}
