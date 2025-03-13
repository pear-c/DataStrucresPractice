package Queue;

import List.XLinkedList;
import List.XList;

import java.util.Comparator;
import java.util.Iterator;

public class XPriorityQueue<T> implements XQueue<T> {

    Comparator<T> comparator;
    XList<T> list;

    public XPriorityQueue(Comparator<T> comparator) {
        list = new XLinkedList<T>();
        this.comparator = comparator;
    }

    @Override
    public void enqueue(T element) {
        list.add(element);
        list.sort(comparator);
    }

    @Override
    public T dequeue() {
        return list.remove(0);
    }

    @Override
    public T peek() {
        return list.get(0);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public XQueue<T> copy() {
        XQueue<T> copy = new XPriorityQueue<>(comparator);
        for(int i=0; i<list.size(); i++) {
            copy.enqueue(list.get(i));
        }
        return copy;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
