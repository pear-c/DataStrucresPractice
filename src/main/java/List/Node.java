package List;

public class Node<T> {
    private T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }
}
