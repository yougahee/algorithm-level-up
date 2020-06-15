package level3;


public class Immigration {
    public static void main(String[] args) {

        int[] times = {7,10};

        System.out.println(solution(6, times));

    }

    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        long mid;
        long left = 0;
        long right = 0;
        long sum;

        for(int time : times) {
            if(right <time) {
                right = time;
            }
        }

        right = right *n;


        while(right >= left) {
            mid = (right + left) /2;
            sum =0;

            for(int time:times){
                sum+=mid/time;
            }

            if(sum >= n) {

                if(mid < answer) {
                    answer = mid;
                }
                right = mid -1;


            }
            else {

                left = mid + 1;
            }
        }

        return answer;
    }
}
