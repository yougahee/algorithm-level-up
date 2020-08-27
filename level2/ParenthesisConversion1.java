package level2;

public class ParenthesisConversion1 {
    public static void main(String[] args) {
        String p = "(()())()";
        String p1 = ")(";
        String p2 = "()))((()";

        String answer = solution(p);
        System.out.println(answer);
        System.out.println(solution(p1));
        System.out.println(solution(p2));
    }

    static String answer;

    static public String solution(String p) {
        answer = "";
        String u = "";

        int leftS =0, rightS = 0;

        for(int i=0; i<p.length(); i++) {

            if(p.charAt(i) == '(' )
                leftS++;
            else
                rightS++;

            u += p.charAt(i);

            if(leftS == rightS) {
                if(alright(u)) {
                    answer = answer.concat(u);
                }else {
                    //1. 첫번째 문자열에 ( 를 추가,
                    //2. 앞에서 한 left , right 쪼갤 수 있을 때까지 쪼개야한다.

                    rightconversion(u);
                }

                u = "";
                leftS = 0;
                rightS = 0;
            }
        }



        return answer;
    }

    //올바른 괄호 문자열
    static public boolean alright(String str) {
        boolean ans = false;

        if(str.charAt(0) == '(' && str.charAt(str.length()-1) == ')') {
            ans = true;
        }

        return ans;
    }

    static public void rightconversion(String str) {

        if(str.length() == 2) {
            answer += "()";
            return;
        }else {




            answer += "(";
            String test =  str.substring(1, str.length()-1);
            System.out.println("test : " + test);
            rightconversion(str.substring(1, str.length()-1));
            answer += ")";
        }
    }
}
