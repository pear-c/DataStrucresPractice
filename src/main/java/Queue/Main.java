package Queue;

import List.XLinkedList;

public class Main {
    public static void main(String[] args) {
        XQueue<Integer> queue = new XListQueue<>(new XLinkedList<Integer>());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue());  // 출력: 10
        queue.enqueue(40);

        System.out.println(queue.peek());  // 출력: 20
        System.out.println(queue.size());  // 출력: 3

        XQueue<Integer> newQueue = queue.copy();
        System.out.println(newQueue.peek());
        System.out.println(newQueue.size());  // 출력: 3
    }
}
