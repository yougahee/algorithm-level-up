package level2;

public class StringCompression {
    public static void main(String[] args) {

        String a = "aabbaccc";
        //result --> 9
        String b = "ababcdcdababcdcd";
        String c = "abcabcdede";
        String d = "abcabcabcabcdededededede";

        System.out.println(solution(d));
    }

    public static int solution(String s) {
        int answer, min = Integer.MAX_VALUE;

        for(int i=1; i<s.length()/2; i++) {
            answer = Compression(s, i);

            min = Math.min(answer, min);
        }

        return min;
    }

    public static int Compression(String str, int size) {
        String temp = str;

        for(int i=0; i<size; i++) {

        }
        char a = temp.charAt(0);
        int cnt = 1;
        for(int i=1; i<str.length(); i++) {
            char ch = temp.charAt(i);

            if(a == ch) {
                cnt++;
            }

            else{

                a = ch;
            }
        }

        return temp.length();
    }
}
