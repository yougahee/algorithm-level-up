package level2;

import java.util.Arrays;
import java.util.Collections;

public class FindMinimumValue {
    public static void main(String[] args) {
        int[] A = {1,4,2};
        int[] B = {5,4,4};

        System.out.println(solution(A, B));
    }

    public static int solution(int []A, int []B)
    {
        int answer = 0;
        Integer[] bCopy = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(A);
        Arrays.sort(bCopy, Collections.reverseOrder());

        for(int i=0; i<A.length; i++) {
            answer += A[i] * bCopy[i];
        }

        return answer;
    }
}
