package level2;

import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelope {

    public static void main(String[] args) {

        int[] progresses = {93,55,30,30};
        int[] speeds = {1,5,30,30};

        int[] answer;

        answer = solution(progresses, speeds);
        System.out.println(answer[0] + " " + answer[1] );
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        int cnt;

        //배열에서 앞에 꺼 중에 100이상이면 cnt ++ 하고
        while (index < progresses.length-1){
            cnt=0;
            int x = (100- progresses[index]) / speeds[index];

            if((100- progresses[index]) % speeds[index] != 0)
                x++;

            for(int i=index; i<progresses.length; i++)
                progresses[i] += speeds[i] * x;


            for(int i= index ; i<progresses.length; i++) {

                if(progresses[i] >=100) {
                    cnt++;
                    index++;
                }else{
                    break;
                }
            }
            queue.add(cnt);
        }

        if(index == progresses.length-1)
            queue.add(1);


        answer = new int[queue.size()];

        for(int i=0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
}
