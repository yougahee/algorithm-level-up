package codeChanllenge1;

import java.util.Arrays;

public class TriangleSnail {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(Arrays.toString(solution(n)));

        //System.out.println(solution(5));
       // System.out.println(6);
    }

    static int cnt=1;
    static int x =0;
    static int y =0;
    static int[][] snail;

    public static int[] solution(int n) {
        int size = n*(n+1)/2;

        int[] answer = new int[size];
        snail = new int[n][n];

        down(n);

        int index =0;
        for(int i=0; i<snail.length; i++) {
            for(int j=0; j<=i; j++) {
                answer[index++] = snail[i][j];
            }
        }
        return answer;
    }

    public static void down(int n) {
        if(n == 0)
            return;

        for(int i=0; i<n; i++) {
            snail[x++][y] = cnt++;
        }
        x--;
        y++;
        right(n-1);
    }

    public static void right(int n) {
        if(n == 0)
            return;

        for(int i=0; i<n; i++) {
            snail[x][y++] = cnt++;
        }
        x--;
        y -= 2;
        cross(n-1);
    }

    public static void cross(int n) {
        if(n == 0)
            return;

        for(int i=0; i<n; i++) {
            snail[x--][y--] = cnt++;
        }
        x += 2;
        y++;
        down(n-1);
    }

    public static void print(int[][] snail) {
        for(int i=0; i<snail.length; i++) {
            for(int j=0; j<snail.length; j++) {
                System.out.print(snail[i][j]);
            }
            System.out.println();
        }
    }
}
