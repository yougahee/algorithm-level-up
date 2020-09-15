package level2;

public class ExpectedRound {
    public static void main(String[] args) {
        System.out.println(solution(8,1,7));
    }

    public static int solution(int n, int a, int b)
    {

        return gameRound(a, b, 1);
    }

    public static int gameRound(int a, int b, int cnt) {

        //0.02~0.04ms, 53.2 ~ 54MB
        if(a/2 + a%2 == b/2 + b%2)
            return cnt;

        a = a/2 + a%2;
        b = b/2 + b%2;

        return gameRound(a,b,cnt+1);
    }
}
