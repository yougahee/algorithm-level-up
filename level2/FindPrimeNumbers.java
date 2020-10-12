package level2;


import java.util.Arrays;
import java.util.HashSet;

//숫자의 범위가 조금이라도 컸다면, 무조건 시간초과였을 것이다.
//순열(n!) * 에라토스테네스의 체(logN) 상당히.. 실행시간이 큼..
public class FindPrimeNumbers {
    public static void main(String[] args) {
        System.out.println(solution("1234567"));
    }

    static int cnt =0;
    static HashSet<Integer> hashSet = new HashSet<>();

    public static int solution(String numbers) {
        int index = 0;
        int[] arr = new int[numbers.length()];
        int[] output;
        boolean[] visited;

        for(char i : numbers.toCharArray()) {
            arr[index++] = Character.getNumericValue(i);
        }

        for(int i=1; i<=arr.length; i++) {
            output = new int[i];
            visited = new boolean[arr.length];
            permutation(arr, output, visited, arr.length, i, 0);
        }

        return cnt;
    }

    public static void permutation(int[] arr, int[] output, boolean[] visited, int n, int r, int temp) {

        if(temp == r)  {
            String makeInt = "";
            for(int i=0; i<output.length; i++) {
                makeInt += output[i];
            }

            if(hashSet.contains(Integer.parseInt(makeInt))) return;
            else hashSet.add(Integer.parseInt(makeInt));

            //소수인지 판별해야함.
            if(isPrimeNumber(Integer.parseInt(makeInt)))
                cnt++;
            return;
        }
        else {
            for(int i=0; i<n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    output[temp] = arr[i];
                    permutation(arr, output, visited, n, r,temp+1);
                    visited[i] = false;
                }
            }
        }
    }

    public static boolean isPrimeNumber(int n) {
        boolean[] prime = new boolean[n+1];
        int index;
        Arrays.fill(prime, true);
        //true인 것이 소수임

        if(n <= 1)
            return false;

        for(int i=2; i<n+1; i++) {
            if(prime[i]) {
                index = 1;
                while (i*(index+1) <= n) {
                    prime[i*(index+1)] = false;
                    index++;
                }
            }
        }

        return prime[n];
    }
}
