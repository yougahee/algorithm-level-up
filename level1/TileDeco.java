package level1;

import java.util.Arrays;

public class TileDeco {
    public static void main(String[] args) {

        int budget =6;
        System.out.println(solution(budget));
    }


    public static long solution(int N) {

        //피보나치 수열
        long[] fibonacci = new long[N];
        fibonacci[0] =1;
        fibonacci[1] =1;

        for(int i=2; i<N; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        //DP
        long DP[] = new long[N];
        DP[0] =4;
        for(int i=1; i<N; i++) {
            DP[i] = DP[i-1] + fibonacci[i]*2;
        }


        return DP[N-1];
    }
}
