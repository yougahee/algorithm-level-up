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