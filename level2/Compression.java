package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Compression {
    public static void main(String[] args) {
        String msg = "KAKAO";
        //System.out.println(Arrays.toString(solution(msg)));

        String msg1 = "TOBEORNOTTOBEORTOBEORNOT";
        System.out.println(Arrays.toString(solution(msg1)));
    }

    public static int[] solution(String msg) {
        int[] answer;
        ArrayList<Integer> arrAnswer = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        String temp = "", now, next;
        int index = 27, cnt;

        for (int i = 0; i < 26; i++) {
            char a = (char) ('A' + i);
            hashMap.put(Character.toString(a), i + 1);
        }

        for (int i = 0; i < msg.length(); i++) {

            cnt =0;

            now = Character.toString(msg.charAt(i));

            if (i + 1 < msg.length())
                next = Character.toString(msg.charAt(i + 1));
            else
                next = "";

            temp = now + next;

            while (hashMap.containsKey(temp)) {
                now = temp;
                cnt++;

                if (i + cnt + 1 < msg.length()) {
                    temp += msg.charAt(i + cnt + 1);
                }else {
                    break;
                }
            }

            if(!hashMap.containsKey(temp)) {
                hashMap.put(temp, index);
                index++;
            }

            if (cnt != 0) {
                i += cnt;
            }

            arrAnswer.add(hashMap.get(now));
        }

        answer = new int[arrAnswer.size()];

        index=0;
        for(int data : arrAnswer) {
            answer[index++] = data;
        }

        return answer;
    }
}
