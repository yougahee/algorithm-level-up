package KAKAO_RECRUIT_2020;

import java.util.Arrays;

public class LyricsSearch {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        System.out.println(Arrays.toString(solution(words, queries)));
    }


    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        StringBuffer sb;
        String[] reverseWords = new String[words.length];

        for(int i=0; i<words.length; i++) {
            sb = new StringBuffer();
            sb.append(words[i]);
            reverseWords[i] = sb.reverse().toString();
        }

        Arrays.sort(words);
        System.out.println(Arrays.toString(words));

        Arrays.sort(reverseWords);
        System.out.println(Arrays.toString(reverseWords));


        for(int i=0; i<queries.length; i++) {
            int left = 0, right = queries.length-1, middle, ans=0;
            String query = queries[i];

            query = query.replace("?", "");
            System.out.println(query);


            //물음표는 앞에 존재.
            if(queries[i].charAt(0) == '?') {

            }
            else {

                while (left <= right) {

                    middle = left + right /2;

                    if(words[middle].startsWith(query)) {
                        ans = middle;
                        left = middle + 1;
                    }else {
                        right = middle -1;
                    }
                }

                //ans를 구했으면, ans의 index부터 words를 탐색해서 일치하는 것만 숫자를 세어서..
                answer[i] = countNum(ans, words, query);
            }
        }

        return answer;
    }

    public static int countNum(int index, String[] words, String start) {
        int cnt =0;

        for (int i= index; i<words.length; i++) {

        }

        return cnt;
    }
}
