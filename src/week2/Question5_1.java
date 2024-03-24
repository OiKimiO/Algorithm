package week2;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Question5_1 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = new int[]{7,4,5,6};

        Queue<Integer> truckQueue = new LinkedList<>();
        Map<Integer, Integer> bridgeMap = new HashMap<>();

        for(int truck_weight: truck_weights){
            truckQueue.add(truck_weight);
        }

        int answer = 0;
        int sum = 0;
        while(true) {
            answer++;

            if (bridgeMap.containsKey(answer)){
                bridgeMap.remove(answer);
            }

            // stream의 mapToInt는 class에서 ReferencePipeline을 확인하면 됨
            sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();

            if (!truckQueue.isEmpty()){
                if (sum + truckQueue.peek() <= weight){
                    bridgeMap.put(answer + bridge_length, truckQueue.poll());
                }
            }

            if (bridgeMap.isEmpty() && truckQueue.isEmpty()){
                break;
            }
        }

        System.out.println(answer);
    }
}
