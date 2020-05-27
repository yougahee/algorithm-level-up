package level1;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {

        int[] d = {1,3,2,5,4};
        int budget =9;
        System.out.println(solution(d, budget));
    }


    public static int solution(int[] d, int budget) {
        int answer = 0;

        //오름차순 정렬
        Arrays.sort(d);

        //budget예산
        for(int i=0; i<d.length; i++) {
            budget = budget-d[i];

            if(budget <= 0){
                break;
            }
            answer++;
        }


        return answer;
    }


}
