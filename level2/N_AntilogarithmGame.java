package level2;

public class N_AntilogarithmGame {
    public static void main(String[] args) {
        int n =2, t = 4, m = 2, p =	1;
        System.out.println(solution(n,t,m,p));

        int n1 =16, t1 = 16, m1 = 2, p1 =1;
        System.out.println(solution(n1, t1, m1, p1));

        int n2 =16, t2 = 16, m2 = 2, p2 =2;
        System.out.println(solution(n2, t2, m2, p2));
    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        String totalGameNumber= "0";

        int makeSize = t*m+p;
        int num = 1;

        while (makeSize >= totalGameNumber.length()) {
            totalGameNumber += makeAntilogarithm(n, num);
            num++;
        }

        for(int i=0; i<t; i++) {
            answer += totalGameNumber.charAt( m*i + (p-1) );
        }

        return answer;
    }

    //10진법 -> n진법 계산하는 함수
    public static String makeAntilogarithm(int n, int num) {
        char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String data = "";

        while (num > 0) {
            data = table[num % n] + data;
            num /= n;
        }

        return data;
    }
}
