package Queue;

import List.XLinkedList;
import List.XList;

import java.util.Iterator;

public class XListQueue<T> implements XQueue<T> {
    private final XList<T> list;

    public XListQueue(XLinkedList<T> list) {
        this.list = list;
    }

    @Override
    public void enqueue(T element) {
        list.add(element);
    }

    @Override
    public T dequeue() {
        if(list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return list.remove(0);
    }

    @Override
    public T peek() {
        if(list.isEmpty()) {
            throw new IllegalArgumentException();
        }
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
        XQueue<T> newQueue = new XListQueue<>(new XLinkedList<T>());
        for(int i=0; i<list.size(); i++) {
            newQueue.enqueue(list.get(i));
        }
        return newQueue;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
