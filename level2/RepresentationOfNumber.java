package level2;

public class RepresentationOfNumber {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int cnt = 0;
        int[] arr = new int[n+1];

        for(int i=0; i<arr.length; i++)
            arr[i] = i;

        int left = 0, right = 0, prefixSum = 0;

        while (true) {
            if(left == n) break;
            if(prefixSum == n) cnt++;

            if(prefixSum < n && right < n) {
                right++;
                prefixSum += arr[right];
            }else {
                left++;
                prefixSum -= arr[left];
            }
        }


        return cnt;
    }
}
