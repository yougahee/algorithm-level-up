package level3;

import java.util.ArrayList;

public class Ranking {

    public static void main(String[] args) {
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(solution(5, results));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0, win, lose;
        Node[] nodes = new Node[n + 1];
        boolean[] visited;

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
            nodes[i].win = new ArrayList<>();
            nodes[i].lose = new ArrayList<>();
        }

        for (int i = 0; i < results.length; i++) {
            win = results[i][0];
            lose = results[i][1];

            nodes[win].addWin(lose);
            nodes[lose].addLose(win);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];

            int cnt = BFS(nodes, i, visited, 0);
            cnt += BFSLose(nodes, i, visited, 0);

            if(cnt == n-1)
                answer++;
        }

        return answer;
    }

    //win
    public static int BFS(Node[] nodes, int index, boolean[] visited, int cnt) {
        for (int i : nodes[index].win) {
            if (i != 0 && !visited[i]) {
                visited[i] = true;
                cnt = BFS(nodes, i, visited, cnt+1);
            }
        }

        return cnt;
    }

    //lose
    public static int BFSLose(Node[] nodes, int index, boolean[] visited, int cnt) {

        for (int i : nodes[index].lose) {
            if (i != 0 && !visited[i]) {
                visited[i] = true;
                cnt = BFSLose(nodes, i, visited, cnt+1);
            }
        }

        return cnt;
    }

    public static class Node {
        ArrayList<Integer> win;
        ArrayList<Integer> lose;

        public void addWin(int win) {
            this.win.add(win);
        }

        public void addLose(int lose) {
            this.lose.add(lose);
        }
    }
}
