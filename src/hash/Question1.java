package hash;

import java.util.HashSet;

public class Question1 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,3};
        int max = nums.length / 2;
        HashSet<Integer> hash = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            hash.add(num);
        }

        System.out.println(Math.min(max, hash.size()));
    }
}
