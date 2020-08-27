package level2;

import java.util.ArrayList;

public class StringCompression {
    public static void main(String[] args) {

        String a = "aabbaccc";
        //result --> 9
        String b = "ababcdcdababcdcd";
        String c = "abcabcdede";
        String d = "abcabcabcabcdededededede";
        String e = "xababcdcdababcdcd";
        String aa = "s";

        System.out.println(solution(a));
    }

    public static int solution(String s) {
        int answer, min = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            answer = Compression(s, i);
            min = Math.min(answer, min);
        }

        return min;
    }

    public static int Compression(String str, int size) {
        System.out.println("===============================");
        System.out.println("size 가? : " + size);

        String temp = "";
        String substring = str.substring(0, size);
        String next, addStr;

        ArrayList<String> array = new ArrayList<>();

        int cnt = 1;
        int i;

        int exist = str.length() % size;

        for(i=0; i<= str.length() - size; i += size) {
            array.add(str.substring(i, i+size));
        }

        for(i=0; i<array.size()-1; i++) {
            if(array.get(i).equals(array.get(i+1))) {
                cnt++;
            }
            else{
                if(cnt != 1) {
                    temp += cnt;
                }
                temp += array.get(i);
                cnt =1;
            }
        }

        if(cnt != 1) {
            temp += cnt;
        }
        temp += array.get(array.size()-1);

        System.out.println(i);
        System.out.println(temp +"  " +  temp.length() + "  exist : " + exist);

        return temp.length() + exist;
    }
}

/*

class Solution {

    public static int solution(String s) {
        int answer, min = Integer.MAX_VALUE;

        for(int i=1; i<= s.length()/2; i++) {
            answer = Compression(s, i);
            min = Math.min(answer, min);
        }
        return min;
    }

    public static int Compression(String str, int size) {

        String temp = str;
        String substring = str.substring(0, size);
        String sub, replaceStr = substring;

        int cnt=1;

        for(int i = size; i<str.length(); i = i+size) {

            if(i+size > str.length())
                break;

            sub = str.substring(i, i + size);

            //System.out.println("sub의 값은 ? : " + sub + "  i의 값은 ? : " + i);

            if(substring.equals(sub)) {
                cnt++;
                replaceStr = replaceStr + sub;

                //System.out.println("여기 들어가는 i값 : " + i);
                //맨 마지막 비교
                if(i+size == str.length()) {
                    //System.out.println("여기 들어가?" );
                    temp = temp.replaceFirst(replaceStr, cnt+substring);
                    //System.out.println(temp);
                }
            }else {
                if(cnt > 1) {
                    temp = temp.replaceFirst(replaceStr, cnt+substring);
                    //System.out.println("원래값 : "+ replaceStr + " cnt+sub : " + cnt + substring);
                }

                substring = sub;
                replaceStr = sub;
                cnt = 1;
            }
        }

        return temp.length();
    }
}
*/
