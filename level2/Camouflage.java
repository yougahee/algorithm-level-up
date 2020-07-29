package level2;

import java.util.HashMap;
import java.util.Set;

public class Camouflage {
    public static void main(String[] args) {

        String[][] clothes= { {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}	};

        System.out.println(solution(clothes));

    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0)+1 );
        }

        Set<String> keySet = hashMap.keySet();

        for(String key : keySet) {
            answer *= hashMap.get(key) + 1;
        }

        return answer-1;
    }
}
