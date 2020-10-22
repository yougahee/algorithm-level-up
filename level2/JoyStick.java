package level2;

public class JoyStick {

    public static void main(String[] args) {
        System.out.println(solution("BBBAAAB"));
    }


    static int cnt;
    public static int solution(String name) {
        int answer = 0;

        for (char a : name.toCharArray()) {
            answer += Math.min(a - 'A', 'Z' - a + 1);
        }

        findMinValue(name, 0);


        return answer + cnt;
    }

    public static void findMinValue(String name, int count) {

        if (name.length() == 0) {
            cnt = Math.min(cnt, count);
            return;
        }

        String temp = name.substring(1);
        int firstCnt = 0, secondCnt = 0;

        //오른쪽으로 가는 경우
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'A') {
                firstCnt++;
            } else {
                findMinValue(name.substring(firstCnt), count+1);
                break;
            }
        }

        //왼쪽으로 가는경우
        for (int i = name.length() - 1; i >= 0; i--) {
            if (name.charAt(i) == 'A') {
                secondCnt++;
            } else {
                findMinValue(name.substring(secondCnt), count+1);
                break;
            }
        }

    }
}
