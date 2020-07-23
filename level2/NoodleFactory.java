package level2;

import java.util.*;

public class NoodleFactory {
    public static void main(String[] args) {

        int[] dates = {4,10,15};
        int[] supplies = {20,5,10};
        int stock = 4;
        int k = 30;


        int[] N2 = {1, 1, 100};
        int number3 = 100;

        System.out.println(solution(stock, dates, supplies, k));
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int index = 0;

        Queue<Integer> priorityQueue = new PriorityQueue(Comparator.reverseOrder());

        for(int i=0; i<k; i++) {
            if( index < dates.length && dates[index] == i ){
                priorityQueue.add(supplies[index]);
                index++;
            }

            if(stock == 0 && !priorityQueue.isEmpty())
            {
                answer++;
                stock += priorityQueue.poll();
            }

            stock--;
        }

        return answer;
    }
}
