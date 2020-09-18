package codeChanllenge1;

import java.util.Arrays;
import java.util.HashSet;

public class PickTwoAdd {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};

        System.out.println(solution(numbers));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};

        HashSet<Integer> hashSet = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                hashSet.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int[hashSet.size()];

        int i=0;
        for(int a : hashSet) {
            answer[i++] = a;
        }

        Arrays.sort(answer);

        return answer;
    }


}
