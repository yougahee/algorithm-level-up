package level1;

public class FindDecimal {
    public static void main(String[] args) {

        int n = 5;
        System.out.println(solution(n));
    }

    //에라토스테네스의 체
    public static int solution(int n) {
        int answer=0;
        int[] arr = new int[n+1];

        for(int i=2; i<=n; i++)
            arr[i] = i;

        for(int i=2; i<=n; i++) {
            if(arr[i] ==0) continue;

            //배수를 다 0으로
            for(int j=i*2; j<=n; j+=i) {
                arr[j] =0;
            }
        }

        for(int i=0; i<arr.length; i++) {
            if(arr[i] !=0) {
                answer++;
            }
        }

        return answer;
    }


}


