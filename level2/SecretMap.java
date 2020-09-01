package level2;

import java.util.Arrays;

public class SecretMap {

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        System.out.println(Arrays.toString(solution(n, arr1, arr2)));

        int n1 = 6;
        int[] arr11 = {46, 33, 33, 22, 31, 50};
        int[] arr22 = {27, 56, 19, 14, 14, 10};

        System.out.println(Arrays.toString(solution(n1, arr11, arr22)));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String temp = "";
        int bitResult;

        StringBuilder binaryString;


        for (int i = 0; i < n; i++) {

            binaryString = new StringBuilder();

            bitResult = arr1[i] | arr2[i];
            String add = Integer.toBinaryString(bitResult);
            binaryString.append(add);

            while (binaryString.length() < n) {
                binaryString.insert(0,"0");
            }

            for (int k = 0; k < n; k++) {
                if (binaryString.charAt(k) == '1')
                    temp += "#";
                else
                    temp += " ";
            }

            answer[i] = temp;
            temp = "";
        }

        return answer;
    }
}
