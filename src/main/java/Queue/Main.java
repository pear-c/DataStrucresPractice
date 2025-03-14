package Queue;

import List.XLinkedList;

public class Main {
    public static void main(String[] args) {
        XQueue<Integer> queue = new XListQueue<>(new XLinkedList<Integer>());  // 내부적으로 연결 리스트 사용

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue());  // 출력: 10
        queue.enqueue(40);

        System.out.println(queue.peek());  // 출력: 20
        System.out.println(queue.size());  // 출력: 3
    }
}
