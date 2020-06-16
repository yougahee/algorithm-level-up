package level1;

import java.beans.PropertyEditorSupport;
import java.util.HashSet;

public class GymSuit {
    public static void main(String[] args) {
        int n =5;
        int[] lost = {2, 4};
        int[] reserve = {1,3,5};

        //set 사용 --> O(1)
        //진짜 순수하게 잃어버린 애들, 여벌옷을 가지고 있는 애들을 찾아서 비교해주는 걸로


        int answer = solution(n, lost, reserve);


        System.out.println(answer);
    }


    public static int solution(int n, int[] lost, int[] reserve) {
        n = n - lost.length;
        int cnt =0;

        for(int i=0; i<reserve.length; i++) {
            for(int j=0; j<lost.length; j++) {
                if(lost[j] == reserve[i]) {
                    lost[j] = -10;
                    reserve[i] = -10;
                }
                else if(lost[j] == -10 || reserve[i] == 10) {
                    continue;
                }
            }
        }

        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {

                if(lost[i] == -10 || reserve[j] == -10) {
                    continue;
                }

                if(lost[i] -1 == reserve[j]) {
                    reserve[j] = -10;
                    cnt++;
                    break;
                }
                else if(lost[i] +1 == reserve[j]) {
                    reserve[j] = -10;
                    cnt++;
                    break;
                }

            }
        }

        return n + cnt;
    }
}
