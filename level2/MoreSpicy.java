package level2;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String[] args) {

        int[] N = {1, 2, 3, 9, 10, 12};
        int number = 7;


        int[] N2 = {1, 1, 100};
        int number3 = 100;

        System.out.println(solution(N, number));
        System.out.println(solution(N2, number3));
    }

    public static int solution(int[] scoville, int K) {
        int answer = -1;
        int mixedscovile =0;
        int cnt=1;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int sco : scoville)
            priorityQueue.add(sco);

        while (priorityQueue.size() > 1){
            mixedscovile = priorityQueue.poll() + (priorityQueue.poll() * 2);
            priorityQueue.add(mixedscovile);

            if(priorityQueue.peek() >= K)
                return cnt;

            cnt++;
        }

        if(priorityQueue.peek() >=K)
            return cnt;


        return answer;
    }
}
