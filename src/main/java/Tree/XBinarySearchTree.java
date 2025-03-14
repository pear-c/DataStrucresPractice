package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class XBinarySearchTree<T extends Comparable<T>> implements XBinaryTree<T> {
    class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node<T> root;
    private int size;

    public XBinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void insert(T value) {
        Objects.requireNonNull(value, "Value cannot be null");

        root = insertTree(root, value);
        size++;
    }
    private Node<T> insertTree(Node<T> node, T value) {
        if(node == null) {
            return new Node<>(value);
        }

        // 삽입하려는 데이터가 더 작을 때
        if(value.compareTo(node.value) < 0) {
            node.left = insertTree(node.left, value);
        } else if(value.compareTo(node.value) > 0) {
            node.right = insertTree(node.right, value);
        }
        return node;
    }

    @Override
    public boolean search(T value) {
        Objects.requireNonNull(value, "Value cannot be null");

        return searchTree(root, value);
    }
    private boolean searchTree(Node<T> node, T value) {
        if(node == null) {
            return false;
        }

        if(value.compareTo(node.value) == 0) {
            return true;
        } else if(value.compareTo(node.value) < 0) {
            return searchTree(node.left, value);
        } else {
            return searchTree(node.right, value);
        }
    }
//    private Node<T> searchTree(Node<T> node, T value) {
//        if(node == null || node.value == value) {
//            return node;
//        }
//
//        if(value.compareTo(node.value) < 0) {
//            return searchTree(node.left, value);
//        }
//        else {
//            return searchTree(node.right, value);
//        }
//    }

    @Override
    public void delete(T value) {
        Objects.requireNonNull(value, "Value cannot be null");

        if(deleteTree(root, value) != null)
            size--;
    }
    private Node<T> deleteTree(Node<T> node, T value) {
        if(node == null) {
            return null;
        }

        if(value.compareTo(node.value) < 0) {
            node.left = deleteTree(node.left, value);
        } else if(value.compareTo(node.value) > 0) {
            node.right = deleteTree(node.right, value);
        } else {
            // 삭제될 노드를 찾은 경우
            if(node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            }

            // 두 자식이 모두 있는 경우
            Node<T> minValue = findMin(node.right);
            node.value = minValue.value;
            node.right = deleteTree(node.right, minValue.value);
        }
        return node;
    }
    private Node<T> findMin(Node<T> node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return findHeight(root);
    }
    private int findHeight(Node<T> node) {
        if(node == null) {
            return -1;
        }

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public List<T> inorderTraversal() {
        List<T> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    private void inorder(Node<T> node, List<T> result) {
        if(node != null) {
            inorder(node.left, result);
            result.add(node.value);
            inorder(node.right, result);
        }
    }
}
