package week2;

import java.util.Stack;

public class Question1 {
    public static void main(String[] args) {
        int []arr = new int[]{1,1,3,3,0,1,1};

        Stack<Integer> stk =  new Stack<>();
        for(int number : arr){
            if(stk.size() == 0){
                stk.add(number);
                continue;
            }

            if(stk.peek() != number){
                stk.add(number);
            }
        }

        int size = stk.size();
        int[] answer = new int[size];

        for(int i = size-1; i >= 0 ; i--){
            answer[i] = stk.pop();
        }

        for(int num : answer){
            System.out.println(num);
        }

    }
}
