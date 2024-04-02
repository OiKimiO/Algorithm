package week2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PQ_Question6 {
    public static void main(String[] args) {
        // int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        // int[][] jobs = {{4, 10}, {0, 10}, {5, 11}, {15, 2}}; // 요청 들어온 순서대로 값이 없는 경우
        int[][] jobs = {{0, 5}, {10, 3}}; // 작업의 소요시간의 끝에 요청 들어온 시간이 포함되지 않는 경우

        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);

        /*Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                System.out.println(a[0] + " " + b[0]);
                return a[0] - b[0];
            }
        });*/

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int index = 0;
        int count = 0;
        int total = 0;
        int end = 0;
        while(count < jobs.length) {

            while(index < jobs.length && jobs[index][0] <= end) {
                pq.add(jobs[index++]);
            }

            if(pq.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] cur = pq.poll();
                total += cur[1] + end - cur[0];
                end += cur[1];
                count++;
            }
        }
    }
}
