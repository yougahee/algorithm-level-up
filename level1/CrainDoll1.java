package level1;

import java.util.Stack;

public class CrainDoll1 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    static public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int x;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            x = moves[i]-1;

            for (int j = 0; j < board.length; j++) {
                int next = board[j][x];

                if(next == 0)
                    continue;

                board[j][x] = 0;
                if(stack.isEmpty()) {
                    stack.add(next);
                    break;
                }
                else if(stack.peek() == next) {
                    stack.pop();
                    answer += 2;
                    break;
                }
                else{
                    stack.add(next);
                    break;
                }
            }
        }
        return answer;
    }

}
