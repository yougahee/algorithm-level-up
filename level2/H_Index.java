package level2;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {10, 9, 4, 1, 1};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        int size = citations.length;

        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++) {

            if( size - i > citations[i] )
                answer = citations[i];
            else  {
                return size - i;
            }
        }

        return answer;
    }
}
