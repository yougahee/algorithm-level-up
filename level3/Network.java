package level3;

public class Network {
    public static void main(String[] args) {

        int[][] computer = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(solution(3, computer));

    }


    static int size;
    static int[][] computer;
    static int[] visited;

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        size = n;
        computer = computers;
        visited = new int[n];

        for(int i=0; i<n; i++) {
            computer[i][i] =0;
            if(visited[i] == 0) {
                visited[i] =1;
                DFS(i);
                answer++;
            }
        }

        return answer;
    }

    public static void DFS(int start) {
        for(int i=0; i<size; i++) {
            if(visited[i] ==0 && computer[start][i] == 1) {
                visited[i] =1;
                DFS(i);
            }
        }
    }
}
