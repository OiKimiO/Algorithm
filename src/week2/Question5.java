package week2;

import java.util.LinkedList;
import java.util.Queue;

public class Question5 {
    public static void main(String[] args) {
        int bridge_length = 5;
        int weight = 5;
        int[] truck_weights = new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1};
        int answer = 0;

        Queue<Integer> readyQueue = new LinkedList<>();
        Queue<DrivingTruck> driveQueue = new LinkedList<>();

        for (Integer truck_weight : truck_weights) {
            readyQueue.add(truck_weight);
        }

        while(!readyQueue.isEmpty() || !driveQueue.isEmpty()){
            answer++;

            if(driveQueue.isEmpty()){
                driveTruck(readyQueue, driveQueue);
                continue;
            }

            int truck_position = driveQueue.peek().position;

            if(truck_position < bridge_length){
                int ready_weight = 0;
                int drive_weight = 0;

                if(!readyQueue.isEmpty()){
                    ready_weight = readyQueue.peek();
                }

                if(!driveQueue.isEmpty()){
                    for (DrivingTruck drivingTruck : driveQueue) {
                        drivingTruck.position++;
                        drive_weight += drivingTruck.weight;
                    }
                }

                if(ready_weight + drive_weight <= weight){
                    driveTruck(readyQueue, driveQueue);
                }
                continue;
            }

            if(truck_position == bridge_length){
                driveQueue.poll();

                int ready_weight = 0;
                int drive_weight = 0;

                if(!readyQueue.isEmpty()){
                    ready_weight = readyQueue.peek();
                }

                if(!driveQueue.isEmpty()){
                    for (DrivingTruck drivingTruck : driveQueue) {
                        drivingTruck.position++;
                        drive_weight += drivingTruck.weight;
                    }
                }

                if(ready_weight + drive_weight <= weight){
                    driveTruck(readyQueue, driveQueue);
                }
                continue;
            }

            if(readyQueue.peek() + driveQueue.peek().weight < weight){
                driveTruck(readyQueue, driveQueue);
            }

        }

        System.out.println(answer);
    }

    private static void driveTruck(Queue<Integer> readyQueue, Queue<DrivingTruck> driveQueue) {
        if(readyQueue.isEmpty()){
           return;
        }

        int truck_weight = readyQueue.poll();
        DrivingTruck drivingTruck = new DrivingTruck(truck_weight, 1);
        driveQueue.add(drivingTruck);
    }

    static class DrivingTruck{
        int weight;
        int position;

        public DrivingTruck(int weight, int position) {
            this.weight = weight;
            this.position = position;
        }
    }
}
