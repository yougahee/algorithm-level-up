package level3;

import java.util.Arrays;

public class ChangeMoney {
    public static void main(String[] args) {
        int[] money = {1,2,5};
        System.out.println(solution(5, money));
    }

    //dp문제인 것까진 파악했는데, 풀이방법이 떠오르지 않았다.ㅠㅠ
    //wow... 상당히 어렵다..........ㅠㅠ
    public static int solution(int n, int[] money) {
        Arrays.sort(money);
        int[] dp = new int[n+1];

        dp[0] = 1;
        for(int i=0; i<money.length; i++) {
            for(int j=money[i]; j<=n; j++) {
                dp[j] = dp[j] + dp[j-money[i]];
            }
        }

        return dp[n] % 1000000007;
    }
}
