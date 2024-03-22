package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question2 {
    public static void main(String[] args) {
        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};

        List<Integer> list = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        int count = 0;
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            double speed = speeds[i];
            double remain = 100 - progress;
            int day = (int) Math.ceil(remain/speed);

            if(stk.isEmpty()){
                stk.add(day);
                count++;
                continue;
            }

            int different = stk.peek() - day;

        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            answer[i] = number;
        }

        System.out.println(list);
    }
}
