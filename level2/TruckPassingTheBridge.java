package level2;

import java.util.*;

//1차시도 실패.. -> 왜지?
public class TruckPassingTheBridge {
    public static void main(String[] args) {
        int[] truck_weights = {7, 4, 5, 4, 4};
        int[] truck_weights1 = {1, 2, 1, 2};
        int[] truck_weights2 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        System.out.println(solution(2, 10, truck_weights));
        System.out.println(solution(2, 4, truck_weights1));
        System.out.println(solution(100, 100, truck_weights2));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> queue = new LinkedList<>();

        int time = 0, weightCnt = 0;
        for (int i = 0; i < truck_weights.length; i++) {

            if (weightCnt + truck_weights[i] <= weight) {
                if(queue.size() == bridge_length) {
                    time = queue.peek().time + bridge_length;
                    weightCnt -= queue.poll().weight;
                }else {
                    time++;
                }
            }
            while (weightCnt + truck_weights[i] > weight) {
                Truck truck = queue.poll();
                time = truck.time + bridge_length;
                weightCnt -= truck.weight;
            }


            weightCnt += truck_weights[i];
            System.out.println("time : " + time + " weight " + weightCnt);
            queue.add(new Truck(truck_weights[i], time));
        }

        while (!queue.isEmpty()) {
            Truck truck_end = queue.poll();
            time = truck_end.time + bridge_length;
        }

        return time;
    }

    public static class Truck {
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
}
