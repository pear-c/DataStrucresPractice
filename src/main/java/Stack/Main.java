package Stack;

public class Main {
    public static void main(String[] args) {
        XStack<Integer> stack = new XLinkedStack<>();
        stack.push(10);
        stack.push(20);

        System.out.println(stack.pop());
        System.out.println(stack.size());

        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
