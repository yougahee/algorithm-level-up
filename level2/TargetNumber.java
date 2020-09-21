package level2;

public class TargetNumber {
    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;


        int arr = solution(numbers, target);
        System.out.println(arr);

    }


    static int[] output;
    static int cnt=0;
    static int targetnum;
    static int[] numbers1;

    public static int solution(int[] numbers, int target) {

        int size = numbers.length;
        int[] arr = {1,2};
        output = new int[size];
        targetnum = target;
        numbers1 = numbers;

        permutation(arr, 0, size);

        return cnt;
    }

    public static void permutation(int[] arr, int depth, int n) {
        if(depth == n) {
            //target이랑 같은지 실행
            isRightTarget();
            return;
        }

        for(int i=0; i<2; i++) {
            output[depth] = arr[i];
            permutation(arr, depth+1, n);
        }


    }

    public static void isRightTarget() {

        int sum = 0;

        for(int i=0; i<output.length; i++) {
            switch (output[i]) {
                case 1:
                    sum += numbers1[i];
                    break;
                case 2:
                    sum -= numbers1[i];
                    break;
            }
        }

        if(sum == targetnum) {
            //System.out.println(Arrays.toString(output));

            cnt++;
        }
    }

}