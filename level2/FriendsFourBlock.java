package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FriendsFourBlock {

    public static void main(String[] args) {

        int m = 4, n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(m, n, board));

        int mm = 6, nn = 6;
        String[] boards = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        //System.out.println(solution(mm, nn, boards));
    }

    public static Character[][] board_char;
    static int[] dx = {0,1,1};
    static int[] dy = {1,0,1};
    static ArrayList<pair> arrayList = new ArrayList<>();

    static class pair {
        int x, y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int m, int n, String[] board) {

        board_char = new Character[m][n];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<n; j++)
                board_char[i][j] = board[i].charAt(j);
        }

        //print
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++)
                System.out.print(board_char[i][j]);
            System.out.println();
        }

        System.out.println("==================");

        while (eraseBlock(m,n)) {

            makeZero();

            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++)
                    System.out.print(board_char[i][j]);
                System.out.println();
            }

            System.out.println("==================");

            dropBlock(m,n);

            System.out.println("=============================");
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++)
                    System.out.print(board_char[i][j]);
                System.out.println();
            }

            arrayList.clear();
        }

        return countBlock(m, n);
    }

    public static boolean eraseBlock(int m, int n) {
        boolean isErase = false;
        int cnt =0;

        for(int i=0; i<m-1; i++) {
            for(int j=0; j<n-1; j++) {
                char a = board_char[i][j];
                int nx, ny;

                for(int k=0; k<3; k++){
                    nx = i + dx[k];
                    ny = j + dy[k];

                    if(board_char[nx][ny] == a && board_char[nx][ny] != '0')
                        cnt++;
                    else
                        break;
                }

                System.out.println(cnt);

                if(cnt == 3) {
                    isErase = true;
                    arrayList.add(new pair(i, j));
                }
                cnt = 0;
            }
        }

        return isErase;
    }

    public static void makeZero() {
        int nx, ny;

        for(int i=0; i<arrayList.size(); i++) {
            pair pair = arrayList.get(i);
            int x = pair.x;
            int y = pair.y;
            board_char[x][y] = '0';

            for(int k=0; k<3; k++){
                nx = x + dx[k];
                ny = y + dy[k];

                board_char[nx][ny] = '0';
            }
        }

    }

    public static void dropBlock(int m, int n) {

        Queue<Character> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=m-1; j>=0; j--) {
                System.out.println("i : " + i + " j : " + j );
                System.out.println(board_char[j][i]);
                if(board_char[j][i] != '0') {
                    queue.add(board_char[j][i]);
                }
            }

            char x = 0;
            for(int j = m-1; j>=0; j--) {
                if(queue.size() != 0){
                    x = queue.poll();
                }
                else {
                    x = '0';
                }

                board_char[j][i] = x;
            }
        }
    }

    public static int countBlock(int m, int n) {
        int cnt =0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board_char[i][j] == '0')
                    cnt++;
            }
        }

        return cnt;
    }
}
