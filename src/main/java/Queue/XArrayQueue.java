package Queue;

import java.util.Arrays;
import java.util.Iterator;

public class XArrayQueue<T> implements XQueue<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public XArrayQueue(int capacity) {
        this.queue = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.capacity = capacity;
        this.size = 0;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        @SuppressWarnings("unchecked")
        T[] newQueue = (T[]) new Object[newCapacity];

        for(int i=0; i<size; i++) {
            newQueue[i] = queue[(front + i) % capacity];
        }

        queue = newQueue;
        front = 0;
        rear = size;
        capacity = newCapacity;
    }

    @Override
    public void enqueue(T element) {
        if(size == capacity) {
            resize();
        }
        queue[rear] = element;
        rear = (rear + 1) % capacity;
        size++;
    }

    @Override
    public T dequeue() {
        T element = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    @Override
    public T peek() {
        if(queue[front] == null) {
            throw new IllegalArgumentException();
        }
        return queue[front];
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
    public void clear() {
        Arrays.fill(queue, null);
    }

    @Override
    public XQueue<T> copy() {
        XQueue<T> newQueue = new XArrayQueue<>(capacity);
        for(int i=0; i<size; i++) {
            newQueue.enqueue(queue[i]);
        }
        return newQueue;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
