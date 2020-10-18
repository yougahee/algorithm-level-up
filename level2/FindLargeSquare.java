package level2;

public class FindLargeSquare {
    public static void main(String[] args) {
        int[][] board = {{0,0,1,1}, {1,1,1,1}};
        System.out.println(solution(board));
    }

    public static int solution(int [][]board)
    {
        int answer = 0;

        if(board.length <=1 || board[0].length <= 1) {
            loop:
            for(int i=0; i<board.length; i++) {
                for(int j=0; j<board[0].length; j++) {
                    if(board[i][j] == 1) {
                        answer = 1;
                        break loop;
                    }
                }
            }
        }
        else {
            for(int i=1; i<board.length; i++) {
                for(int j=1; j<board[i].length; j++) {
                    if(board[i][j] >= 1) {
                        board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]) + 1;

                        answer = Math.max(answer, board[i][j]);
                    }
                }
            }
        }

        return answer*answer;
    }
}
