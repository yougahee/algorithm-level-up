package KAKAO_RECRUIT_2020;

public class ParenthesisConversion {
    public static void main(String[] args) {
        String p = "(()())()";
        System.out.println(solution(p));
    }

    public static String solution(String p) {
        return tryString(p);
    }

    public static String tryString(String str) {
        if(str.length() == 0)
            return str;

        String result = "";

        int rightCnt=0, leftCnt=0;
        String u,v;

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(')
                rightCnt++;
            else
                leftCnt++;

            if(leftCnt == rightCnt) {
                u = str.substring(0, i+1);
                v = str.substring(i+1);
                //System.out.println("u : " + u + " v :  " + v);

                //u가 올바른
                if(isRightString(u)) {
                    u += tryString(v);
                    return u;
                }else {
                   result += "(";
                   result += tryString(v);
                   result += ")";
                   u = u.substring(1, u.length()-1);
                   result += reverse(u);
                }
                break;
            }
        }

        return result;
    }

    public static boolean isRightString(String u) {
        if(u.charAt(0) == '(' && u.charAt(u.length()-1) == ')')
            return true;

        return false;
    }

    public static String reverse(String u) {
        String temp = "";

        for(int i=0; i<u.length(); i++) {
            if(u.charAt(i) == '(')
                temp += ')';
            else
                temp += '(';
        }

        return temp;
    }
}
