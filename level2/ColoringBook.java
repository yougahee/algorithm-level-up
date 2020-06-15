package level2;

import java.util.Arrays;

public class ColoringBook {
    public static void main(String[] args) {

        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int m =6;
        int n = 4;

        System.out.println(Arrays.toString(solution(m,n,picture)));

    }

    static int[] dx = {-1,1,0,0};//상하좌우
    static int[] dy = {0,0,-1,1};
    static int[][] copyPicture;
    static int mSize, nSize;
    static int cnt=0;

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        copyPicture = picture;
        mSize = m;
        nSize = n;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(copyPicture[i][j] != 0) {
                    cnt=0;
                    DFS(i, j, picture[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void DFS(int x, int y, int value){
        int nx, ny;
        copyPicture[x][y] = 0;
        cnt++;

        for(int i=0; i<4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx >=0 && nx < mSize && ny >=0 && ny < nSize && copyPicture[nx][ny] == value)
            {
                DFS(nx,ny,value);
            }
        }
    }
}
