package Tree;

public class Main {
    public static void main(String[] args) {
        XBinaryTree<Integer> bst = new XBinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);

        bst.delete(6); // 5 삭제

        System.out.println(bst.size());   // 출력: 4
        System.out.println(bst.search(5)); // 출력: false

        bst.inorderTraversal(); // 출력: 3 7 10 15
    }
}
