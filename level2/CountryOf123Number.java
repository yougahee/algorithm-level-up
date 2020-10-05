package level2;

public class CountryOf123Number {
    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(6));
        System.out.println(solution(110));
    }

    //생각해내지 못함.. --> 다시 풀기
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] number = {4,1,2};
        int remainder = 0;

        while (n > 0) {
            remainder = n%3;
            n /= 3;

            if(remainder == 0) n--;

            sb.insert(0, number[remainder]);
        }

        return sb.toString();
    }
}
