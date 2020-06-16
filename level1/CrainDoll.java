package level1;

import java.util.Stack;

public class CrainDoll {
    public static void main(String[] args) {


        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }


    public static int solution(int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<>();
        int cnt=0;

        for(int i=0; i<moves.length; i++) {
            int a = moves[i]-1;

            for(int j=0; j<board.length; j++) {
                int k = board[j][a];
                if(k == 0) {
                    continue;
                }else{
                    board[j][a] =0;
                    if(stack.isEmpty()) {
                        stack.push(k);
                        break;
                    }else if(stack.peek() == k){
                        stack.pop();
                        cnt+=2;
                        break;
                    }else {
                        stack.push(k);
                        break;
                    }
                }
            }
        }

        return cnt;
    }
}
