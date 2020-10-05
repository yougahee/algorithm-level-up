package level2;

public class JumpAndTeleportation {
    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }

    public static int solution(int n) {
        int ans = 0;

        while (n > 0) {
            if(n%2 == 0)
                n /= 2;
            else {
                n = (n-1)/2;
                ans++;
            }
        }

        return ans;
    }
}
