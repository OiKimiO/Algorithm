package week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 다시 풀어보기
 *
 * 테스트 케이스: [2, 2, 2, 2]
 * location: 2
 * 정답: 3
 *
 * 테스트 케이스: [1, 2, 3, 4]
 * location: 2
 * 정답: 2
 *
 * 테스트 케이스: [3, 2, 1, 4]
 * location: 0
 * 정답: 2
 *
 * 테스트 케이스: [2, 2, 5, 1, 2, 3]
 * location: 1
 * 정답: 4
 * */

public class Question4 {
    public static void main(String[] args) {
        int[] priorities = new int[]{1,2,3,4};
        int location = 2;

        Queue<Node> queue = new LinkedList<>();
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            Node node = new Node(i, priority);
            queue.add(node);
        }

        int checkSum = 0;
        while (!queue.isEmpty()) {
            Node currentProcess = queue.poll(); // 큐에서 프로세스를 꺼내서 실행

            boolean higherPriorityExists = false;
            // 현재 프로세스보다 우선순위가 높은 프로세스가 있는지 확인
            for (Node node : queue) {
                if (node.priority > currentProcess.priority) {
                    higherPriorityExists = true;
                    break;
                }
            }

            // 더 높은 우선순위가 없으면 실행하고, 그렇지 않으면 큐의 뒤로 다시 추가
            if (higherPriorityExists) {
                queue.add(currentProcess);
                /*for (Node node : queue) {
                    System.out.println(node);
                }
                System.out.println();*/
            }else{
                list.add(currentProcess);
            }
        }

        for(Node process: list){
            System.out.println(process);
        }

        /*for (int i = 1; i <= priorities.length; i++) {
            if(queue.peek().idx == location){
                System.out.println(i);
            }
            queue.add(queue.poll());
        }*/


    }

    static class Node{
        int idx;
        int priority;

        public Node(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", priority=" + priority +
                    '}';
        }
    }
}
