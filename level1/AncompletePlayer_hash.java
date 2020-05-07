package level1;

import java.util.HashMap;

// 해쉬는 공부 다시 하기ㅜㅜ
public class AncompletePlayer_hash {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};

        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String par : participant) hashMap.put(par, hashMap.getOrDefault(par, 0) +1);
        for(String com : completion) hashMap.put(com, hashMap.get(com)-1);

        for(String key : hashMap.keySet()) {
            if(hashMap.get(key) ==1)
                answer = key;
        }

        System.out.println(answer);
    }
}
