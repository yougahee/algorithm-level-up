package level3;

import java.util.ArrayList;
import java.util.Arrays;

// 내 풀이를 사용을 하긴 했지만, long을 사용하는 것이나
//factorial을 재귀호출을 하지 않고 현재 n을 나누어서 사용하는 방법은 참고했음
// 효율성 문제를 많이 풀어봐야 할 것!
public class HowtoLine {
    public static void main(String[] args) {
        int n = 3;
        long k = 5;

        System.out.println(Arrays.toString(solution(n, k)));
    }

    static ArrayList<Long> arrayList;
    static long[] answer;
    static int size;

    public static int[] solution(int n, long k) {
        answer = new long[n];
        arrayList = new ArrayList<>();
        size = n;
        long fact =1;

        for(long i=1; i<=n; i++) {
            arrayList.add(i);
            fact *= i;
        }

        DFS(n, k, fact);

        int index =0;
        int[] intAnswer = new int[n];
        for(long x : answer)
            intAnswer[index++] = (int) x;
        return intAnswer;
    }

    public static void DFS(int n, long k, long factorial) {
        if( n == 1 ) {
            answer[size-n] = arrayList.get(0);
        }
        else {
            long div = factorial/n;
            int index = (int) ((k-1)/div);
            answer[size - n] = arrayList.get( index );
            arrayList.remove(index);

            long x = k%div;
            if(x == 0) x = div;
            DFS(n-1, x, factorial/n);
        }
    }
}
