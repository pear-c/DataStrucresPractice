package Queue;

import List.XLinkedList;

public class Main {
    public static void main(String[] args) {
        XQueue<String> pq = new XPriorityQueue<>((a, b) -> b.length() - a.length());

        pq.enqueue("apple");
        pq.enqueue("banana");
        pq.enqueue("kiwi");

        System.out.println(pq.dequeue());  // 출력: "banana" (가장 긴 문자열)
    }
}
