package level2;

import java.util.Arrays;

public class ColoringBook1 {
    public static void main(String[] args) {

        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int m = 6;
        int n = 4;

        System.out.println(Arrays.toString(solution(m, n, picture)));
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] isChecked;
    static int[][] map;

    static int maxSizeOfOneArea, cnt;
    static int ms, ns;

    static public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        maxSizeOfOneArea = 0;

        isChecked = new boolean[m][n];
        map = picture;
        ms = m;
        ns = n;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isChecked[i][j] && picture[i][j] != 0) {
                    isChecked[i][j] = true;
                    cnt = 0;
                    //System.out.println("i : " + i + " j : " + j + " picture : " + picture[i][j]);
                    DFS(i, j, picture[i][j]);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }


    static void DFS(int x, int y, int num) {
        cnt++;
        int nx, ny;

        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

           // System.out.println("DFS 잘 돌아? : "+ i + " " + nx + " " + ny);

            if (nx >= 0 && nx < ms && ny >= 0 && ny < ns && !isChecked[nx][ny] && num == map[nx][ny]) {
                //System.out.println("nx : " + nx + " ny : " + ny);
                isChecked[nx][ny] = true;
                DFS(nx, ny, num);
            }
        }

        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
    }
}
