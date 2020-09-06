package level3;

import java.util.*;

//범위가 미친듯이 크면 DFS, BFS 말고 바이너리 서치, 등등 O(logN)인 것들을 생각해보자!
public class SteppingStone {
    public static void main(String[] args) {

        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        System.out.println(solution(stones, k));
    }

    public static int solution(int[] stones, int k) {
        int answer = 0;
        int left, right, middle = 0;

        int[] copyStone = stones.clone();
        Arrays.sort(copyStone);

        left = copyStone[0];
        right = copyStone[copyStone.length-1];

        while (left <= right) {
            middle = (left + right ) /2;
            System.out.println(" l : " + left + " r : " + right +  " middle : "  + middle);

            //middle이 된다면,
            if(ParametricSearch(stones, middle, k)) {
                left = middle + 1;
                answer = middle;
            }else {
                right = middle - 1;
            }
        }

        return answer;
    }

    public static boolean ParametricSearch(int[] stones, int middle, int k) {
        int count=0;

        for(int stone : stones) {
            if(stone - middle < 0)
                count++;
            else
                count = 0;

            if(count == k) return false;
        }

        return true;
    }

}
