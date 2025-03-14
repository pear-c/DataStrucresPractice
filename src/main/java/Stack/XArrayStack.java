package Stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class XArrayStack<T> implements XStack<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private T[] array;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public XArrayStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = 10;
        this.size = 0;
    }

    private void resize() {
        array = Arrays.copyOf(array, capacity * 2);
        capacity *= 2;
    }

    @Override
    public void push(T element) {
        Objects.requireNonNull(element, "Value cannot be null");
        
        if(size == capacity) {
            resize();
        }
        array[size++] = element;
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        T element = peek();
        array[--size] = null;
        return element;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
