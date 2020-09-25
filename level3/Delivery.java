package level3;


import java.util.LinkedList;
import java.util.Queue;

public class Delivery {
    public static void main(String[] args) {
        int N = 6;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int k = 4;

        System.out.println(solution(N, road, k));
    }

    static int[] dist;
    static boolean[] visited;

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int MaXVALUE = 1000000;

        visited = new boolean[N+1];
        int[][] roadMap = new int[N+1][N+1];
        dist = new int[N+1];

        int x, y, value;
        for(int i=0; i<road.length; i++) {
            x = road[i][0];
            y = road[i][1];
            value = road[i][2];

            System.out.println("x : " + x + " y : " + y);

            if(roadMap[x][y] != 0) {
                value = Math.min(roadMap[x][y], value);
            }

            roadMap[x][y] = value;
            roadMap[y][x] = value;
        }

        dist[1] = 0;
        for(int i=2; i<=N; i++){
            dist[i] = MaXVALUE;
        }

        Dijkstra(N, roadMap);

        for( int dist_value : dist) {
            if(dist_value <= K)
                answer++;
        }

        return answer-1;
    }

    public static void Dijkstra(int N, int[][] roadMap) {
        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;

            for(int i= 1; i<=N; i++) {
                if(roadMap[node][i] != 0 && !visited[i]) {
                    dist[i] = Math.min(dist[i], dist[node]+roadMap[node][i]);
                    System.out.println("i의 값 : " + i + " dist의 값 :  " + dist[i]);

                    queue.add(i);
                }
            }
        }
    }
}
