package level3;

import java.util.Arrays;

public class HowtoLine {
    public static void main(String[] args) {

        int n = 3;
        int k = 5;

        System.out.println(Arrays.toString(solution(n,k)));

    }

    static int[] answer;
    static int[] isChecked;
    static int[] realanswer;
    static int cnt=0;

    public static int[] solution(int n, long k) {

        int[] arr = new int[n];
        answer = new int[n];
        isChecked = new int[n];
        realanswer = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        permutation(n, k, arr,0, true);

        return realanswer;

    }

    public static void permutation(int n, long k, int[] arr, int depth, boolean istrue) {

        //하나의 배열을 완성시키면
        if(depth == n) {
            cnt++;
            if( k == cnt) {
                System.arraycopy(answer, 0, realanswer, 0 , answer.length);
                istrue = false;
                return;
            }

            return;
        }


        for(int i=0; i<n; i++) {

            if(isChecked[i] == 0) {

                answer[depth] = arr[i];
                isChecked[i] = 1;
                isChecked[i] = 0;
            }

        }

    }
}
