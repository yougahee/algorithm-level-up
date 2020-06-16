package level2;

public class GroundEating {
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};


        System.out.println(solution(land));
    }

    //굳이 DP배열을 하나 안만들어도 된다!
    static int solution(int[][] land) {
        int answer = 0;
        int r = land.length;

        for(int i=1; i<r; i++) {
            land[i][0] = land[i][0] + Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] = land[i][1] + Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] = land[i][2] + Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
            land[i][3] = land[i][3] + Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }

        for(int i=0; i<4; i++) {
            if(answer < land[r-1][i])
                answer = land[r-1][i];
        }

        return answer;
    }
}
