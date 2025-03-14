package Map;

public class Node<K, V> {
    Entry<K, V> entry;
    Node<K, V> left;
    Node<K, V> right;

    public Node(K key, V value) {
        this.entry = new Entry<>(key, value);
        this.left = null;
        this.right = null;
    }
}
