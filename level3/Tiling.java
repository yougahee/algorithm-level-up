package level3;

public class Tiling {

    public static void main(String[] args) {
        System.out.println(solution(1500));
    }

    public static int solution(int n) {
        long[] dp = new long[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i= 3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) %  1000000007;
            System.out.println(dp[i]);
        }

        return (int) dp[n]% 1000000007;
    }
}