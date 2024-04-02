package week2;

import java.util.PriorityQueue;

public class Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> asc = new PriorityQueue<Integer>();
        PriorityQueue<Integer> desc = new PriorityQueue<Integer>((a,b) -> b - a);

        asc.add(1);
        asc.add(2);
        asc.add(3);

        desc.add(1);
        desc.add(2);
        desc.add(3);

        System.out.println(asc);
        System.out.println(desc.poll());
        System.out.println(desc.poll());
        System.out.println(desc.poll());

    }
}