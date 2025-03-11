package List;

public class Node implements Comparable<Node>{
    private Object data;
    public Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }

    @Override
    public int compareTo(Node o) {
        if(this.getData().getClass().equals(o.getClass())){
            if(this.data instanceof Comparable) {
                Comparable c = (Comparable)this.data;

                return c.compareTo(o.getData());
            }
        }
        return 0;
    }
}
