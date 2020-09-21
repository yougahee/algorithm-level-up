package level2;

public class TargetNumber1 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        System.out.println(solution(numbers, 3));
    }

    static int[] dx = {1, -1};
    static int ans = 0;
    public static int solution(int[] numbers, int target) {
        BFS(numbers, target, 0, 0);

        return ans;
    }


    public static void BFS(int[] numbers, int target, int sum, int cnt) {
        int result;

        if(cnt == numbers.length) {
            if(sum == target)
                ans++;
            return;
        }

        for(int j=0; j<2; j++) {
            result = sum + (numbers[cnt] * dx[j]);
            BFS(numbers, target, result, cnt+1);
        }
    }
}
