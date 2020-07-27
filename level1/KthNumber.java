package level1;

import java.util.Arrays;

public class KthNumber {
    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = 	{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution(array,commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int start, end, k;

        for(int i=0; i<commands.length; i++) {
            start = commands[i][0];
            end = commands[i][1];
            k = commands[i][2];

            int size = end - start + 1;
            int[] new_array = new int[size];
            for(int j=0; j< size; j++) {
                new_array[j] = array[start + j -1];
            }

            Arrays.sort(new_array);
            answer[i] = new_array[k-1];

            //다른 사람 풀이
            //int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
        }

        return answer;
    }
}
