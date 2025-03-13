package Set;

public class Main {
    public static void main(String[] args) {
        XSet<Integer> set = new XHashSet<>();

        set.add(10);
        set.add(20);
        set.add(10); // 중복 허용 안 됨

        System.out.println(set.contains(10)); // 출력: true
        System.out.println(set.contains(30)); // 출력: false
        System.out.println(set.size()); // 출력: 2

    }
}
