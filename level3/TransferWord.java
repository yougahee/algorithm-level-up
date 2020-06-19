package level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class TransferWord {
    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};
        String[] words2 = {"hot", "dot", "dog", "lot", "log", "cog"};


        System.out.println(solution(begin, target, words));
        System.out.println(solution(begin, target, words2));
    }

    static int[] isVisited;
    static int min = Integer.MAX_VALUE;
    static String finalTargetWord;

    public static int solution(String begin, String target, String[] words) {
        finalTargetWord = target;
        isVisited = new int[words.length];

        DFS(begin, words, 0);

        if(min == Integer.MAX_VALUE)
            return 0;

        return min;
    }

    public static void DFS(String beforeWord, String[] wordsArr, int cnt) {

        for(int i=0; i<wordsArr.length; i++) {
            //조건에 만족하면
            if(isVisited[i] == 0 && findOneDifferentWord(beforeWord, wordsArr[i])) {
                cnt++;

                if(finalTargetWord.equals(wordsArr[i])) {
                    //System.out.println("equals에 들어온 녀석" + wordsArr[i] + " " + cnt);
                    whatIsMin(cnt);
                    return;
                }

                isVisited[i] = 1;
                DFS(wordsArr[i], wordsArr, cnt);
                isVisited[i] = 0;
                cnt--;
            }
        }
    }

    public static Boolean findOneDifferentWord(String origin, String compareWord) {

        LinkedList<Character> originData = new LinkedList<>();

        //비교하고자 하는 단어 넣기!
        for(int i=0; i<origin.length(); i++) {
            originData.add(origin.charAt(i));
        }

        for(int i=0; i<compareWord.length(); i++) {
            if(originData.contains(compareWord.charAt(i))){
                originData.remove(originData.indexOf(compareWord.charAt(i)));
            }
        }

        if(originData.size() == 1)
            return true;

        return false;
    }

    public static void whatIsMin(int cnt) {
        if(cnt < min) {
            min = cnt;
        }
    }

}
