package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cache {
    public static void main(String[] args) {

        //String[] cities = {	"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities = {"Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju"};
        int size = 1;

        System.out.println(solution(size, cities));

    }

    public static int solution(int cacheSize, String[] cities) {
        int time=0;
        String city;

        LinkedList<String> cache = new LinkedList<>();

        if(cacheSize == 0)
            return cities.length * 5;

        for (String s : cities) {
            city = s.toLowerCase();

            if (cache.contains(city)) {
                cache.remove(city);
                time += 1;
            }
            else{
                if (cache.size() == cacheSize)
                    cache.remove(0);
                time += 5;
            }
            cache.add(city);
        }
        return time;
    }

}
