package level3;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

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

        HashSet<Integer> hashSet = new HashSet<>();

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


        String str = "ghghghghgh";
        put(str, "에베베");
        System.out.println(str);


        return answer-1;
    }

    public static void put (String before, String after) {
        before = after;
    }

    public static void Dijkstra(int N, int[][] roadMap) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int dis =  o1.distance - o2.distance;
                if(dis == 0)
                    return o1.index - o2.index;
                return dis;
            }
        });
        pq.add(new Pair(1,0));

        while (!pq.isEmpty()) {
            Pair node = pq.poll();

            int index = node.index;
            int value = node.distance;

            if(!visited[index]) {
                for(int i= 1; i<=N; i++) {
                    if(roadMap[index][i] != 0) {
                        dist[i] = Math.min(dist[i], value+roadMap[index][i]);
                        //System.out.println("i의 값 : " + i + " dist의 값 :  " + dist[i]);
                        pq.add(new Pair(i, dist[i]));
                    }
                }
            }
            visited[index] = true;
        }
    }

    static class Pair {
        int index, distance;

        public Pair(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
