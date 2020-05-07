package level1;

import java.beans.PropertyEditorSupport;

public class GymSuit {
    public static void main(String[] args) {
        int n =5;
        int[] lost = {1, 4};
        int[] reserve = {3};

        //set 사용 --> O(1)
        //진짜 순수하게 잃어버린 애들, 여벌옷을 가지고 있는 애들을 찾아서 비교해주는 걸로

        GymSuitSolution solution = new GymSuitSolution();
        int answer = solution.solution(n, lost, reserve);

        ////
        System.out.println(answer);
    }
}

class GymSuitSolution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n+2];

        for(int i=0; i<lost.length; i++) {
            int lostnum = lost[i];
            student[lostnum] = -1;
        }

        for(int i=0; i<reserve.length; i++) {
            int reserveNum = reserve[i];
            student[reserveNum] = 1;
        }

        //student 배열에는 순수하게 옷을 잃어버린, 여벌 옷 가지고 있는 사람만 존재
        for(int i=1; i<=n; i++) {
            //잃어버린 친구
            if(student[i] == -1) {
                //앞에 여벌 옷이 있는지 보고
                if(student[i-1] == 1){
                    student[i-1] =0;
                    student[i] = 0;
                }
                //뒤에 보고
                else if(student[i+1] == 1) {
                    student[i+1]=0;
                    student[i] =0;
                }
            }
        }
        int cnt =0;
        //개수 세기
        for(int i=1; i<=n; i++) {
            if(student[i] == -1)
                cnt++;
        }
        return n - cnt;
    }
}
