package level2;

public class IronBar {
    public static void main(String[] args) {

        String arr = "()(((()())(())()))(())";

        System.out.println(solution(arr));
    }

    public static int solution(String arrangement) {
        int answer = 0;
        int cnt = 0;

        for (int i = 0; i < arrangement.length() - 1; i++) {

            if (arrangement.substring(i, i + 2).equals("()")) {
                answer += cnt;
                i = i+1;
            } else if (arrangement.charAt(i) == '(') {
                cnt++;
                answer++;
            } else {
                cnt--;
            }
        }
        return answer;
    }
}
