package Stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class XLinkedStack<T> implements XStack<T> {
    private Node<T> top;
    private int size;

    public XLinkedStack() {
        this.top = null;
        size = 0;
    }

    @Override
    public void push(T element) {
        Objects.requireNonNull(element, "Value cannot be null");

        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        T element = top.data;
        top = top.next;
        size--;
        return element;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    class Node<T> {
        T data;
        Node<T> next;

        public Node(T element) {
            this.data = element;
            next = null;
        }
    }
}
