package level3;

import java.util.HashSet;

public class BrainsWorry {
    public static void main(String[] args) {
        String sentence = "AAAaBaAbBBBBbCcBdBdBdBcCeBfBeGgGGjGjGRvRvRvRvRvR";
        //String sentence = "SpIpGpOpNpGJqOqA";

        String sentence1 = "aIaAM";

        System.out.println(solution(sentence));
        System.out.println(solution(sentence1));
    }

    static char rule2_1Char = '0';

    public static String solution(String sentence) {
        String answer = "", data = "";
        HashSet<Character> hashSet = new HashSet<>();
        int checkIdx = -1;

        //공백이 있으면 invalid
        if (sentence.contains(" "))
            return "invalid";

        for (int i = 0; i < sentence.length(); i++) {
            char character = sentence.charAt(i);

            System.out.println("i의 값 : " + i + " " + sentence.substring(i));

            //만약, 이전에 사용했던 character가 나왔다면?
            if (hashSet.contains(character))
                return "invalid";

            //특수기호일 경우,
            if (character >= 'a' && character <= 'z') {

                //rule2에 만족하는지? -->
                int rule2Index = rule2(character, sentence);
                if (rule2Index >= 0) {
                    //index가 온다..
                    String temp = sentence.substring(i + 1, rule2Index);
                    System.out.println(rule2Index);
                    i = rule2Index;
                    checkIdx = i;
                    System.out.println("temp : " + temp + " checkIdx : " + checkIdx);

                    rule2_1Char = '0';
                    //temp에 또다른 특수기호들이 있다면?!
                    if (hasSpecialChar(temp)) {
                        //rule1에 무조건 만족시키지 않다면, 넌 무조건 틀린 것이다!!!!
                        //특수문자는 hashset에 존재해서는 안되고, 서로 다르면 안되고,
                        //만족시킨다면, hashset에 추가도 시켜줘야 할텐데?!
                        if(!isRightRule1(rule2_1Char, temp) || hashSet.contains(rule2_1Char)) {
                            return "invalid";
                        }else {
                            hashSet.add(rule2_1Char);
                            temp = temp.replaceAll(Character.toString(rule2_1Char), "");
                        }

                    }

                    //answer에 temp와 공백을 집어넣어준다.
                    if(data.length() >= 1)
                        answer += data + " ";
                    answer = answer + temp + " ";
                    hashSet.add(character);
                }
                //rule1에 만족하는지?
                else {
                    int lastIndex = sentence.lastIndexOf(character);
                    System.out.println("g의 lastIndex : " + lastIndex );

                    if(i-1 <= checkIdx || lastIndex == sentence.length()- 1)
                        return "invalid";

                    if(isRightRule1(character, sentence.substring(i-1, lastIndex+2))) {
                        System.out.println("여기까지 들어가나?");


                        if(data.length() > 1)
                            answer += data.substring(0, data.length()-1) + " ";
                        answer = answer + sentence.substring(i-1, lastIndex+2).replaceAll(Character.toString(character), "") + " ";
                        hashSet.add(character);
                        //이게 맞나? 확인해봐야겠군,,,,
                        i = lastIndex + 1;
                        checkIdx = i;

                        System.out.println(answer + "  " + i);
                    }
                    else{
                        return "invalid";
                    }
                }

                data = "";
            }

            else {
                data += character;
            }
        }

        if(!data.equals(""))
            answer += data;

        //answer 맨 마지막 부분에 공백이 있다면 제거하기?!
        // 이부분이 필요한지는 검사해보기
        if(answer.charAt(answer.length()-1) == ' ')
            answer = answer.substring(0, answer.length()-1);

        return answer;

    }

    public static int rule2(char sign, String sentence) {
        int cnt = 0, index = 0;

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == sign) {
                cnt++;
                index = i;
            }
        }

        if (cnt == 2)
            return index;
        else
            return -1;
    }

    public static boolean hasSpecialChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charStr = str.charAt(i);
            if (charStr >= 'a' && charStr <= 'z') {
                rule2_1Char = charStr;
                return true;
            }
        }
        return false;
    }

    //str이 기본적으로 rule1을 만족시키는지
    public static boolean isRightRule1(char sign, String str) {

        for(int i=0; i<str.length(); i++) {
            char charStr = str.charAt(i);

            if(i%2 == 0) {
                if (charStr >= 'a' && charStr <= 'z') {
                    return false;
                }
            }
            else {
                if(sign != charStr)
                    return false;
            }
        }
        return true;
    }


    public static void rule1(char sign, String sentence) {
        String result = "";

        //sign이 있는 마지막 index까지 잘라서
        System.out.println(sentence.substring(0,sentence.lastIndexOf(sign) +1));

        if(isRightRule1(sign, sentence.substring(0,sentence.lastIndexOf(sign) +1))) {
            System.out.println("str이 만족을 시킵니다!!");
        }else {
            //false
            return;
        }


    }
}
