package week2;

import java.util.Stack;

public class Question3 {
    public static void main(String[] args) {
        String s = ")()(";
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stk.isEmpty()){
                stk.add(c);
                continue;
            }

            switch (c){
                case '(':
                    stk.add('(');
                    break;
                case ')':
                    if(stk.peek() == '('){
                        stk.pop();
                        continue;
                    }
                    stk.add(')');
                    break;
            }
        }

        if(stk.isEmpty()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }



    }
}
