package level2;

public class NthLCM {
    public static void main(String[] args) {
        int[] arr = {2,6,8,14};

        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int num = arr[0];
        for( int i=1; i<arr.length; i++ ) {
            num *= arr[i] / makeLRU(num, arr[i]);
        }

        return num;
    }

    public static int makeLRU(int n1, int n2) {
        int LRU = 1;

        int max = Math.max(n1, n2);

        for(int i=2; i<max; i++) {
            if(n1%i == 0 && n2 % i == 0)
                LRU = i;
        }

        return LRU;
    }
}
