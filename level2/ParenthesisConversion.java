package level2;

//부르트포스 문제! 문제에서 원하는 것을 그대로 수행해주면 된다.
// 문제 해당 설명이 무척 길었고, 문제를 풀이하는 방식을 모두 다 서술해주었다.
// 이럴 때는 이게 왜 이러지? 다른 케이스는 뭘까? 라는 생각보다는 문제에서 제시해주는 플로우 그대로 코드를 짜려고 하면 될 것 같다.
// 너무 쓸데 없는 데에 시간을 많이 쏟았다. --> 다음에 이런 문제 있으면 걍 이해하기보다는 흐름을 파악해서 코드를 짜보자!
public class ParenthesisConversion {

    public static void main(String[] args) {
        String p = "(()())()";

        String answer = solution(p);
        System.out.println(answer);
    }

    public static String solution(String p) {

        return BalanceString(p);
    }

    //올바른 문자열로 만들기
    public static String BalanceString(String s) {
        String answer = "";

        if (s.length() ==0)
            return "";

        int cut = division(s);
        String u = s.substring(0, cut);
        String v = s.substring(cut, s.length());

        if(isCorrect(u)) {
            return u + BalanceString(v);
        }else {
            String blank = "";
            u = u.substring(1, u.length()-1);
            blank = "(" + BalanceString(v) + ")" + Reverse(u);
            return blank;
        }
    }

    //균형잡힌 문자열의 index 반환
    static int division(String s) {
        int left=0;
        int right=0;
        int i;

        for(i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(')
                left++;
            else
                right++;

            if(left == right)
                return i+1;
        }
        return i;
    }

    //맞는지 확인
    static Boolean isCorrect(String s) {
        int count=0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(')
                count++;
            else
                count--;

            if(count<0)
                return false;
        }
        return true;
    }

    //reverse
    static String Reverse(String s) {
        String reverse = "";
        for (int i=0; i<s.length(); i ++) {
            if(s.charAt(i) == '(')
                reverse += ")";
            else
                reverse += "(";
        }
        return reverse;
    }




}


