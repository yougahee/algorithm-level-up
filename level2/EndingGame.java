package level2;

import java.util.HashSet;

public class EndingGame {

    public static void main(String[] args) {

        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] answer = {0,0};

        answer = solution(3, words);
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int cnt=1;

        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add(words[0]);

        for(int i=1; i<words.length; i++) {
            cnt++;

            char front = words[i-1].charAt(words[i-1].length()-1);
            char end = words[i].charAt(0);

            //중복 or 뒷알파벳과 현재단어의 맨앞의 알파벳 일치하는지
            if(hashSet.contains(words[i]) || front != end) {
                return makeAnswer(cnt, n);
            }

            hashSet.add(words[i]);

        }
        return answer;
    }

    public static int[] makeAnswer(int cnt, int n) {
        int[] sol = {0,0};

        //sol[0]
        if(cnt%n == 0) {
            sol[0] = n;
            sol[1] = cnt/n;
        }else {
            sol[0] = cnt%n;
            sol[1] = cnt/n +1;
        }

        return sol;
    }
}
