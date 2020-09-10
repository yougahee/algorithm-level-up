package level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MoveBlock {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};

        System.out.println(solution(board));
    }

    static int[] dx = {-1, 1, 0, 0}; //상하우좌
    static int[] dy = {0, 0, 1, -1};
    static int[][] boardCopy;
    static int size;
    static int min = Integer.MAX_VALUE;

    static ArrayList<robot> arrayRobot;

    public static int solution(int[][] board) {
        size = board.length;
        int robotX1 = 0, robotY1 = 0, robotX2 = 0, robotY2 = 1;

        boardCopy = board;

        arrayRobot = new ArrayList<>();

        Queue<robot> robotQueue = new LinkedList<>();
        robotQueue.add(new robot(0, 0, 0, 1, 0));
        arrayRobot.add(new robot(0, 0, 0, 1, 0) );

        //그냥 로봇 하나로 돌려도 될듯
        robot robot = robotQueue.poll();
        BFS(robot);

//        while (!robotQueue.isEmpty()) {
//            robot robot = robotQueue.poll();
//
//            DFS(robot);
//        }

        return min;
    }

    public static void BFS(robot robot) {
        int x1 = robot.x1, y1 = robot.y1, x2 = robot.x2, y2 = robot.y2;
        int cnt = robot.cnt;
        int nx1, ny1, nx2, ny2;

        System.out.println("cnt : " + cnt);
        System.out.println("x1 : " + x1 + " y1 : " + y1 + " x2 : " + x2 + " y2 : " + y2);

        if (isEnd(robot)) {
            min = Math.min(cnt, min);
            System.out.println("N,N 도착했다!" + min);
            return;
        }

        //상하좌우
        for (int i = 0; i < 4; i++) {
            nx1 = x1 + dx[i];
            ny1 = y1 + dy[i];

            nx2 = x2 + dx[i];
            ny2 = y2 + dy[i];

            //범위에 존재하고
            if (inArea(nx1, nx2, ny1, ny2) && !isExist(nx1, ny1, nx2, ny2) ) {
                 if ( boardCopy[nx1][ny1] == 0 && boardCopy[nx2][ny2] == 0 ) {
                     robot robot1 = new robot(nx1, ny1, nx2, ny2, cnt + 1);

                     arrayRobot.add(robot1);
                     BFS(robot1);
                     arrayRobot.remove(robot1);
                }
            }
        }

        //가로 --> 세로 90도로 바꿈
        if (x1 == x2) {
            //시계방향
            if (inArea(x1-1, y1, x2-1, y2) && !isExist(x1-1,y1+1, x2, y2) ) {
                if (boardCopy[x1-1][y1] == 0 && boardCopy[x2-1][y2] == 0) {
                    robot robot1 = new robot(x1-1, y1+1, x2, y2, cnt + 1);

                    arrayRobot.add(robot1);
                    BFS(robot1);
                    arrayRobot.remove(robot1);
                }
            }

            //반시계방향
            if (inArea(x1+1, y1, x2+1, y2) && !isExist(x2,y2, x1+1, y1+1)) {
                if (boardCopy[x1+1][y1] == 0 && boardCopy[x2+1][y2] == 0) {
                    robot robot1 = new robot(x2,y2, x1+1, y1+1, cnt + 1);
                    arrayRobot.add(robot1);
                    BFS(robot1);
                    arrayRobot.remove(robot1);
                }
            }
        }
        //세로 --> 가로 90도로 바꿈
        else {
            //시계방향
            if (inArea(x1, y1-1, x2, y2-1) && !isExist(x1,y1, x2-1, y2-1)) {
                if (boardCopy[x1][y1-1] == 0 && boardCopy[x2][y2-1] == 0) {
                    robot robot1 = new robot(x1,y1, x2-1, y2-1, cnt+1);

                    arrayRobot.add(robot1);
                    BFS(robot1);
                    arrayRobot.remove(robot1);
                }
            }

            //반시계방향
            if (inArea(x1, y1+1, x2, y2+1) && !isExist(x1,y1, x2-1, y2+1)) {
                if (boardCopy[x1][y1+1] == 0 && boardCopy[x2][y2+1] == 0) {
                    robot robot1 = new robot(x1,y1, x2-1, y2+1, cnt + 1);

                    arrayRobot.add(robot1);
                    BFS(robot1);
                    arrayRobot.remove(robot1);
                }
            }
        }

    }

    public static boolean isExist(int x1, int y1, int x2, int y2) {

        for(robot robot : arrayRobot) {
            if(robot.x1 == x1 && robot.y1 == y1 && robot.x2 == x2 && robot.y2 == y2)
                return true;
        }

        return false;
    }

    public static boolean inArea(int nx1, int nx2, int ny1, int ny2) {
        return nx1 >= 0 && nx2 >= 0 && nx1 < size && nx2 < size && ny1 >= 0 && ny2 >= 0 && ny1 < size && ny2 < size;
    }

    //N*N에 도달했나?!
    public static boolean isEnd(robot robot) {
        int x1 = robot.x1, y1 = robot.y1, x2 = robot.x2, y2 = robot.y2;

        if (size - 1 == x1 && size - 1 == y1) return true;
        else if (size - 1 == x2 && size - 1 == y2) return true;

        return false;
    }

    static class robot {
        int x1, y1, x2, y2;
        int cnt;

        public robot(int x1, int y1, int x2, int y2, int cnt) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cnt = cnt;
        }
    }
}
