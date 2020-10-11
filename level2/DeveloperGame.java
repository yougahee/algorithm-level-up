package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DeveloperGame {
    public static void main(String[] args) {
        int[] front = {10, 8, 4, 8, 2, 14};
        int[] backend = {1, 3, 4, 4, 12, 16};

        System.out.println(solution(front, backend));
    }

    public static int solution(int[] front, int[] backend) {
        int answer = 0;
        int index = 0, backEndSkill;

        Arrays.sort(front);
        Arrays.sort(backend);

        Queue<Integer> queue = new LinkedList<>();

        for(int value : backend) {
            queue.add(value);
        }

        while (!queue.isEmpty()) {
            backEndSkill = queue.poll();

            if(backEndSkill > front[index]) {
                answer++;
                index++;
            }
        }

        return answer;
    }
}
