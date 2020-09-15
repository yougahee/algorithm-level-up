package level3;

import java.util.LinkedList;
import java.util.Queue;

public class TooFarNode {
    public static void main(String[] args) {
        int n =6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, edge));
    }

    //효율성은 아주 좋지 않은 코드!!
    //n*n 을 다 검사
    //ArrayList를 활용하여 edge로 들어오는 곳만 파악하여 문제를 풀어보는 연습을 하자!!
    public static int solution(int n, int[][] edge) {
        int answer = 0, max =0;

        boolean[][] graph = new boolean[n+1][n+1];
        int[] graphCheck = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();

        int x, y;
        for(int i=0; i<edge.length; i++) {
            x = edge[i][0];
            y = edge[i][1];

            graph[x][y] = true;
            graph[y][x] = true;
        }

        queue.add(1);
        graphCheck[1] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for(int i= 2; i<n+1; i++) {
                if(graphCheck[i] == 0 && graph[node][i]) {
                    queue.add(i);
                    graphCheck[i] = graphCheck[node] + 1;

                    if(max < graphCheck[i]) {
                        max = graphCheck[i];
                        answer = 1;
                    }
                    else if(max == graphCheck[i]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
