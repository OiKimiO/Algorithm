package week3;

import java.util.Arrays;

public class SortExample {
    public static void main(String[] args) {
        Integer[] arr = {4,1,5};
        //Arrays.sort(arr);
        Arrays.sort(arr,(a,b) -> a-b);
    }
}
