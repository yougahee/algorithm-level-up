package level2;

public class MakingPrimeNumbers {
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        System.out.println(solution(nums));
    }

    static int answer = 0;
    public static int solution(int[] nums) {
        int[] output = new int[3];
        combination(nums, output, nums.length, 3, 0, 0);

        return answer;
    }

    public static void combination(int[] nums, int[] output, int n, int r, int depth, int target) {
        if(r == 0) {
            int sum =0;
            for(int a : output) {
                sum += a;
            }

            if(isPrimeNumber(sum))
                answer++;
        }
        else if(target == n) return;
        else {
            output[depth] = nums[target];
            combination(nums, output, n, r-1, depth+1, target+1);
            combination(nums, output, n, r, depth, target+1);
        }
    }

    //소수인지 판별
    public static boolean isPrimeNumber(int num) {
        int cnt = 1, index = 1;

        while (index < num) {
            if(cnt > 2)
                return false;

            if(num % (++index) == 0)
                cnt++;
        }

        return cnt == 2;
    }
}
