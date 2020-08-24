package level3;

public class SchoolRoad {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        System.out.println(solution(m,n, puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {

        int[][] dp = new int[n+1][m+1];
        dp[0][1] = 1;

        for(int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        for(int i =1; i< n+1; i++) {
            for(int j=1; j< m+1; j++) {
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = ( dp[i-1][j] + dp[i][j-1] ) % 1000000007;
                }
            }
        }
        return dp[n][m];
    }
}
