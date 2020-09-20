package level3;

import java.util.Arrays;

public class NumberGame {
    public static void main(String[] args) {
        int[] a = {5,1,3,7};
        int[] b = {2,2,6,8};

        System.out.println(solution(a, b));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int index = 0;
        for(int small : A) {
            for(int i = index; i<B.length; i++) {
                if(small < B[i]) {
                    answer++;
                    index = i + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
