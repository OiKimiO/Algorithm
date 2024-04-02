package week2;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.add(1);
        stk.push(1);
        // ConcurrentModificationException 에러 발생
        stk.forEach(a -> {
            stk.add(2);
            System.out.println(a);
        });
    }
}
