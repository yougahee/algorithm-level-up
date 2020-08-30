package level3;

public class Pillar {
    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};

        int n1 = 5;
        int[][] build_frame1 = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};

        int[][] answer;
        answer = solution(n, build_frame);

        for (int i = 0; i < 8; i++) {
            System.out.println("==================================");
            System.out.print(answer[i][0] + " " + answer[i][1] + " " + answer[i][2]);
            System.out.println();
        }
    }

    private static boolean[][] pillar, bo;
    private static int N;
    private static final int PILLAR = 0, BO = 1, REMOVE = 0, ADD = 1;

    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer;

        N = n;
        int count = 0;
        pillar = new boolean[n + 3][n + 3];
        bo = new boolean[n + 3][n + 3];

        int x, y;
        for (int[] frame : build_frame) {
            x = frame[0] + 1;
            y = frame[1] + 1;

            //기둥
            if (frame[2] == PILLAR) {

                if (frame[3] == ADD && isExistPillar(x, y)) {
                    pillar[x][y] = true;
                    count++;
                }

                if(frame[3] == REMOVE && isRemove(x,y,PILLAR)) {
                    pillar[x][y] = false;
                    count--;
                }
            }
            //보
            else{
                if (frame[3] == ADD && isExistBo(x, y)) {
                    bo[x][y] = true;
                    count++;
                }

                if(frame[3] == REMOVE && isRemove(x,y,BO)) {
                    bo[x][y] = false;
                    count--;
                }
            }
        }

        answer = new int[count][3];
        int index = 0;

        for(int i=1; i<=n+1; i++) {
            for(int j=1; j<=n+1; j++) {
                if(pillar[i][j]) answer[index++] = new int[]{i-1, j-1, 0};
                if(bo[i][j]) answer[index++]  = new int[]{i-1,j-1, 1};
            }
        }

        return answer;
    }

    //기둥
    public static boolean isExistPillar(int x, int y) {
        return y == 1 || bo[x-1][y] || bo[x][y] || pillar[x][y-1];
    }

    //보
    public static boolean isExistBo(int x, int y) {
        return pillar[x][y-1] || pillar[x+1][y-1] || (bo[x-1][y] && bo[x+1][y]);
    }

    public static boolean isRemove(int x, int y, int type) {
        boolean result = true;

        if(type == PILLAR)
            pillar[x][y] = false;
        else
            bo[x][y] = false;


        loop:
        for(int i = 1; i<= N; i++) {
            for(int j = 1; j<= N; j++) {
                if(pillar[i][j] && !isExistPillar(i,j)) {
                    result = false;
                    break loop;
                }

                if(bo[i][j] && !isExistBo(i,j)) {
                    result = false;
                    break loop;
                }
            }
        }

        if(type == PILLAR)
            pillar[x][y] = true;
        else
            bo[x][y] = true;

        return result;
    }
}

