package level2;

import java.util.Arrays;

public class MaxAndMin {
    public static void main(String[] args) {
        System.out.println(solution("-1 -2 -3 -4"));
    }

    public static String solution(String s) {
        String answer = "";
        String[] sArr = s.split(" ");
        int[] arr = new int[sArr.length];

        for(int i=0; i<sArr.length; i++) {
            arr[i] = Integer.parseInt(sArr[i]);
        }

        Arrays.sort(arr);

        answer = arr[0] + " " + arr[sArr.length-1];

        return answer;
    }
}
