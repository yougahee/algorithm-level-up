package level4;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MujiEatingLive {
    public static void main(String[] args) {
        int[] food_times = {3,1,2};
        System.out.println(solution(food_times, 5));
    }

    public static int solution(int[] food_times, long k) {

        LinkedList<Food> foods = new LinkedList<Food>();

        int n = food_times.length;
        long isEnough = 0;
        for(int i=0; i < n; i++) {
            foods.add(new Food(i+1, food_times[i]));

            if(isEnough <= k) isEnough += food_times[i];
        }
        if(isEnough <= k) return -1;

        Collections.sort(foods);

        long cnt = 0;

        while ( k > ( foods.get(0).time - cnt ) * n ) {
            k -= ( foods.get(0).time - cnt ) * n;
            cnt = foods.get(0).time;
            foods.remove(0);
            n--;
        }

        Collections.sort(foods, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.num - o2.num;
            }
        });

        return foods.get( (int) ( k % n ) ).num;
    }

    static class Food implements Comparable<Food>{
        int num;
        int time;

        Food(int num, int size) {
            this.num = num;
            this.time = size;
        }

        @Override
        public int compareTo(Food o) {
            return this.time - o.time;
        }
    }
}


//정확성통과코드
/*
    ArrayList<food> arr = new ArrayList<>();

    long isEnough = 0;
        for(int i=0; i<food_times.length; i++) {
        arr.add(new food(i+1, food_times[i]));
        isEnough += food_times[i];
        }

        if(isEnough <= k) return -1;

        int index = 0;
        while(k>0) {
        k--;
        if(arr.get(index).size -1 == 0) {
        arr.remove(index);
        index = (index) % arr.size();
        }else {
        arr.get(index).size -= 1;
        index = (index + 1) % arr.size();
        }
        }

        return arr.get(index).num;*/
