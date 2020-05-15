package level2;

import java.util.Arrays;

public class Top {
    public static void main(String[] args) {
        int[] heights = {6,9,5,7,4};

        TopSolution topSolution = new TopSolution();

        int[] arr = topSolution.solution(heights);
        System.out.println(Arrays.toString(arr));
    }
}


class TopSolution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for(int i = heights.length-1; i >=0; i--) {
            int currentheight = heights[i];

            for(int j = i-1; j>=0; j--) {
                int nextheight = heights[j];

                if(currentheight < nextheight) {
                    answer[i] = j+1;
                    break;
                }
            }
        }

        return answer;
    }
}
