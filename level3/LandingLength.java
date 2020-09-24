package level3;

import java.util.HashSet;

public class LandingLength {
    public static void main(String[] args) {
        System.out.println(solution("LULLLLLLU"));
    }

/* //와후,, 이 방법도 있다..!
    Map<String, int[]> map = new HashMap<>();
        map.put("U", new int[] {0, 1});
        map.put("D", new int[] {0, -1});
        map.put("R", new int[] {1, 0});
        map.put("L", new int[] {-1, 0});*/

    //U, R, D,  L
    static int[] dx = {0, 1, 0,  -1};
    static int[] dy = {1, 0, -1,  0};

    public static int solution(String dirs) {
        int answer = 0;
        dirs = dirs.replace("U", "0").replace("R", "1")
                .replace("D", "2").replace("L", "3");

        HashSet<String> hashSet = new HashSet<>();

        int x = 5, y = 5;

        for(int i=0; i<dirs.length(); i++) {
            int index = dirs.charAt(i) - '0';

            int nx = x + dx[index];
            int ny = y + dy[index];

            if(nx>=0 && nx < 11 && ny >=0 && ny < 11) {
                String temp = x + Integer.toString(y) + index;

                if(!hashSet.contains(temp)) {
                    answer++;
                    hashSet.add(temp);
                    hashSet.add(nx + Integer.toString(ny) + (index+2)%4);
                 }

                x += dx[index];
                y += dy[index];
            }
        }

        return answer;
    }
}
