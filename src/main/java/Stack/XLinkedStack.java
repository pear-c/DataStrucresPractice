package Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class XLinkedStack<T> implements XStack<T> {
    Node<T> head;
    private int size;

    public XLinkedStack() {
        this.head = null;
        size = 0;
    }

    @Override
    public void push(T element) {
        Objects.requireNonNull(element, "Value cannot be null");

        Node<T> current = head;
        Node<T> newNode = new Node<>(element);

        if(current == null) {
            head = newNode;
        }
        else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public T pop() {
        Node<T> current = head;
        Node<T> prev = null;

        if(size == 0) {
            throw new NoSuchElementException();
        }
        if(size == 1) {
            Node<T> result = current;
            head = null;
            size--;
            return result.element;
        }


        while(current.next != null) {
            prev = current;
            current = current.next;
        }
        Node<T> result = current;
        prev.next = null;
        size--;
        return result.element;
    }

    @Override
    public T peek() {
        Node<T> current = head;
        if(current == null) {
            throw new NoSuchElementException();
        }
        while(current.next != null) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
            next = null;
        }
    }
}
