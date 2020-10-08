package codeChallenge2;

public class Test1 {
    public static void main(String[] args) {

        System.out.println(solution(125));
    }

    public static int solution(int n) {
        int answer = 0;
        StringBuilder ans = new StringBuilder();

        while (n > 0) {
            ans.insert(0, n%3);
            n = n/3;
        }

        ans = ans.reverse();

        for(int i=ans.length()-1; i>=0; i--) {
            answer += Math.pow(3, ans.length() - i-1) * Character.getNumericValue(ans.charAt(i));
        }

        return answer;
    }

}
