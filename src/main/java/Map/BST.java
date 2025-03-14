package Map;

import java.util.Comparator;

public class BST<K, V> {
    private Node<K, V> root;
    private int size;

    private final Comparator<? super K> comparator;

    public BST() {
        this(null);
    }

    public BST(Comparator<? super K> comparator) {
        this.comparator = comparator;
        this.root = null;
        this.size = 0;
    }
}
