package level1;

import java.util.ArrayList;

public class GymSuit {

    public static void main(String[] args) {
        int n = 6;
        int[] lost = {5, 6};
        int[] reserve = {4, 5};

        int answer = solution(n, lost, reserve);
        System.out.println(answer);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> lostArr = new ArrayList<>();

        for(int a : reserve) {
            arr.add(a);
        }

        for(int a : lost) {
            if(arr.contains(a)) {
                arr.remove(arr.indexOf(a));
                answer++;
            }
            else {
                lostArr.add(a);
            }
        }

        for(int i=0; i<lostArr.size(); i++) {
            if( arr.contains(lostArr.get(i) - 1) ) {
                //System.out.println("lost-1 : " + (lostArr.get(i) - 1 ));
                arr.remove(arr.indexOf(lostArr.get(i) - 1));
                answer++;
            }
            else if( arr.contains(lostArr.get(i) + 1)) {
                //System.out.println("lost +1 : " + arr.indexOf(lostArr.get(i) +1 ));
                arr.remove(arr.indexOf(lostArr.get(i) + 1));
                answer++;
            }
        }

        return n - lost.length + answer;
    }
}
