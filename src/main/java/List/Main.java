package List;


import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        XList<Integer> list = new XArrayList<Integer>();
        XList<Integer> list = new XLinkedList<Integer>();

//        list.add(10);
//        list.add(20);
//        list.add(1, 15);
//        System.out.println(list.get(1)); // 출력: 15
//
//        list.remove(Integer.valueOf(20));
//        System.out.println(list.contains(20)); // 출력: false

        list.add(8);
        list.add(5);
        list.add(6);
        list.add(2);
        list.add(4);

        list.sort(Integer::compareTo);
        System.out.println(list.get(0));
//
//        XList<Integer> copiedList = list.copy();
//        System.out.println(copiedList.size());



    }
}
