package codeChanllenge1;

import java.util.Arrays;

public class Test2 {
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
        int size = 0;
        int originalN = n;
        for(int i=1; i<=n; i++)
            size +=i;

        int[] answer = new int[size];
        snail = new int[n][n];

        while (n > 0) {
            down(n--);
            //System.out.println("===========");
           // print(snail);

            //System.out.println("===========");
            right(n--);
            //print(snail);

            //System.out.println("===========");
            cross(n--);
            //print(snail);
        }

        int index =0;
        for(int i=0; i<snail.length; i++) {
            for(int j=0; j<=i; j++) {
                answer[index++] = snail[i][j];
            }
        }
        return answer;
    }

    public static void down(int n) {
        //System.out.println("down " + n);

        if(n == 0)
            return;

        for(int i=0; i<n; i++) {
            snail[x][y] = cnt++;
            x = x + 1;
        }
        x--;
        y++;
    }

    public static void right(int n) {
        //System.out.println("right" + n);

        if(n == 0)
            return;

        for(int i=0; i<n; i++) {
            snail[x][y] = cnt++;
            y = y+1;
        }
        x--;
        y -= 2;
    }

    public static void cross(int n) {
        //System.out.println("cross" + n);
        //System.out.println("x의 값 " + x + "y의 값" + y);

        if(n == 0)
            return;

        for(int i=0; i<n; i++) {
            snail[x][y] = cnt++;
            x--;
            y--;
        }
        x += 2;
        y++;

       // System.out.println("x의 값 " + x + "y의 값" + y);
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
