package level2;

import java.util.ArrayList;

public class Cache1 {
    public static void main(String[] args) {

        String[] cities = {	"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        //String[] cities = {"Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju"};
        int size = 2;

        System.out.println(solution(size, cities));

        String[] cities1 = { "Jeju", "Pangyo", "NewYork", "newyork"};

        System.out.println(solution(size, cities1));

    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0)
            return cities.length * 5;

        ArrayList<String> city = new ArrayList<>();

        for(int i=0; i<cities.length; i++) {
            String city_name = cities[i].toLowerCase();

            if(city.contains(city_name)) {
                //해당하는 거 삭제
                city.remove(city_name);
                //맨뒤에 집어 넣기
                city.add(city_name);
                answer += 1;
            }else {
                if(city.size() >= cacheSize) {
                    city.remove(0);
                }

                city.add(city_name);
                answer += 5;
            }

            //System.out.println(city);
        }

        return answer;
    }
}
