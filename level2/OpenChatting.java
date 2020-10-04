package level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class OpenChatting {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        HashMap<String, String> hashMap = new HashMap<>();

        String[][] chatting = new String[record.length][3];

        for(int i=0; i<record.length; i++) {
            chatting[i] = record[i].split(" ");

            //change의 경우,
            if(chatting[i][0].equals("Change"))
                hashMap.replace(chatting[i][1], chatting[i][2]);
            if(chatting[i][0].equals("Enter"))
                hashMap.put(chatting[i][1], chatting[i][2]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<record.length; i++) {
            String temp = "";

            if(chatting[i][0].equals("Enter"))
                temp = hashMap.get(chatting[i][1]) + "님이 들어왔습니다.";
            else if(chatting[i][0].equals("Leave"))
                temp = hashMap.get(chatting[i][1]) + "님이 나갔습니다.";
            else
                continue;

            sb.append(temp + "\n");
        }

        return sb.toString().split("\n");
    }
}
