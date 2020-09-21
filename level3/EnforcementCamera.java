package level3;

import java.util.Arrays;
import java.util.Comparator;

public class EnforcementCamera {
    public static void main(String[] args) {
        int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(routes));
    }

    public static int solution(int[][] routes) {
        int answer = 0;
        boolean[] car = new boolean[routes.length];

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for(int i=0; i<routes.length; i++) {
            if(car[i])
                continue;

            for(int j = i; j<routes.length; j++) {
                if(!car[j] && routes[j][1] >= routes[i][0])
                    car[j] = true;
            }
            answer++;
        }


        return answer;
    }
}
