package level2;

import java.util.Arrays;
import java.util.Stack;

public class MakeBigNumber {
    public static void main(String[] args) {
        String number = "1010";
        int k =2;

        System.out.println(solution(number, k));

    }

    //만족스럽지 못한 코드다.. 다른 사람들은 어떻게 했는지 봐보도록 하자!!
    public static String solution(String number, int k) {
        //10번 해결방법
        StringBuilder answer = new StringBuilder();
        int start =0;
        int max = 0;
        int index =0;
        int originalK = k;

        String [] chars = new String[number.length()];
        int[] intnumber = new int[number.length()];
        chars = number.split("");


        for(int i=0; i<number.length(); i++)
            intnumber[i] = Integer.parseInt(chars[i]);


        while (start+k < number.length()) {
            max=0;
            for(int i = start; i<= start+k; i++) {
                if(max < intnumber[i]) {
                    max = intnumber[i];
                    index = i;
                }
            }

            //System.out.println("index" + index);

            //가장 큰 수 를 answer에 집어 넣기
            answer.append(max);
            //System.out.println("answer의 값?" + answer);

            k = k - index + start;
            start = index+1;
        }


        if(answer.length() != number.length() - originalK) {
            for(int i=start; i<number.length(); i++) {
                answer.append(intnumber[i]);
            }
        }


        //7777일 경우, 10000일 경우
        if(answer.length() > number.length() -k) {
            answer.delete(answer.length()-k-1, answer.length()-1);
        }


        return answer.toString();
    }

    public String Othersolution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
