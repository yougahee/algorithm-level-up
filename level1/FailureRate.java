package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FailureRate {
    public static void main(String[] args) {
        int n = 7;
        int[] stages = {1,2,2,5,5};

        System.out.println(Arrays.toString(solution(n, stages)));
    }

    static class Pair implements Comparable<Pair>{
        int stage;
        double failure;

        Pair(int stage, double failure) {
            this.stage = stage;
            this.failure = failure;
        }

        @Override
        public int compareTo(Pair o) {
            int r = new Double(this.failure).compareTo(o.failure)*-1;
            if(r == 0)
                r = this.stage - o.stage;
            return r;
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        ArrayList<Pair> arrayList = new ArrayList<>();
        Arrays.sort(stages);

        int index = 0, user = stages.length;
        double fail;
        for(int i = 1; i<=N; i++) {
            int cnt = 0;
            while (index < stages.length && i == stages[index]) {
                cnt++;
                index++;
            }

            if(user == 0)
                fail =0;
            else {
                fail = (double) cnt/user;
                user -= cnt;
            }

            System.out.println("cnt  : " + cnt + " fail : " + fail);
            arrayList.add(new Pair(i, fail));
        }

        Collections.sort(arrayList);

        index =0;
        for(Pair pair : arrayList) {
            answer[index++] = pair.stage;
        }

        return answer;
    }

}
