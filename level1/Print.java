package level1;

import java.util.*;
import java.util.concurrent.DelayQueue;

public class Print {
    public static void main(String[] args) {

        int[] priorty = {2, 1, 3, 2};

        System.out.println(solution(priorty,2));
    }


    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int max;

        Deque<Integer> deque = new LinkedList<>();

        for(int i=0; i<priorities.length; i++) {
            deque.addLast(priorities[i]);
        }

        while (!deque.isEmpty()) {
            max =0;

            location -= 1;

            for(int a : deque) {
                max = Math.max(a, max);
            }

            if(deque.getFirst() == max) {
                answer++;
                deque.pollFirst();

                if(location < 0)
                    return answer;

            }else {
                int poll= deque.pollFirst();
                deque.addLast(poll);
                if(location < 0)
                    location = deque.size()-1;

            }
        }

        return answer;
    }
}
