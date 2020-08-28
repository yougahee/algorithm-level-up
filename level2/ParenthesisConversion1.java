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

        if (p.length() == 0)
            return answer;

        rightconversion(p);

        return answer;
    }

    //올바른 괄호 문자열
    static public boolean alright(String str) {
        boolean ans = false;

        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            ans = true;
        }

        return ans;
    }

    static public void rightconversion(String str) {
        int leftS = 0, rightS = 0;
        String u = "";
        String v = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                leftS++;
            else
                rightS++;

            u += str.charAt(i);

            if (leftS == rightS) {
                v = str.substring(i+1);

                //System.out.println("u의 값 : " + u + " v의 값 : " + v);

                if (alright(u)) {
                    answer = answer.concat(u);
                } else {
                    answer += "(";
                    rightconversion(v);
                    answer += ")";

                    if(u.length() > 2)
                        answer += Convert(u.substring(1, u.length()-1));
                    return;
                }

                //System.out.println("answer의 값 : " + answer);

                u = "";
                leftS =0;
                rightS =0;
            }
        }
    }

    static public String Convert(String str) {
        String answer = "";

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ')')
                answer += '(';
            else
                answer += ')';
        }
        return answer;
    }

}
