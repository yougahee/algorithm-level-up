package level2;

import java.util.*;

public class FormulaMaximization {

    public static void main(String[] args) {
        String p = "100-200*300-500+20";
        String p1 = "50*6-3*2";

        //System.out.println(solution(p));
        System.out.println(solution(p1));
    }

    static ArrayList<Long> number = new ArrayList<>();
    static ArrayList<Character> operator = new ArrayList<>();

    static long max = Integer.MIN_VALUE;

    public static long solution(String expression) {
        long answer = 0;
        String temp = "";

        for (int i = 0; i < expression.length(); i++) {
            char a = expression.charAt(i);

            if (a == '*' || a == '+' || a == '-') {
                operator.add(a);
                //System.out.println(temp);
                number.add(Long.parseLong(temp));
                temp = "";
            } else {
                temp += a;
            }
        }


        //마지막으로 들어갈 숫자 넣어주기
        number.add(Long.parseLong(temp));

        char[] arr = {'+', '*', '-'};
        char[] output = new char[3];
        boolean[] visited = new boolean[3];

        Permutation(arr, output, visited, 0, 3, 3);

        number.clear();
        operator.clear();

        return max;
    }

    public static void Permutation(char arr[], char[] output, boolean[] visited, int depth, int n, int r) {

        if (r == depth) {
            System.out.println(Arrays.toString(output));
            findMax(output);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                Permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    public static void findMax(char[] output) {
        ArrayList<Long> copy_number = new ArrayList<>();
        ArrayList<Character> copy_operator = new ArrayList<>();

        copy_number.addAll(number);
        copy_operator.addAll(operator);

        long result = 0;

        for (char aa : output) {
            int num = 1;
            for (int i = 0; i <copy_operator.size(); i+=num) {
                if(aa == copy_operator.get(i)){

                    long n1 = copy_number.get(i);
                    long n2 = copy_number.get(i+1);

                    System.out.println(n1 +  " " +n2);

                    if( aa == '+')
                        result = n1 + n2;
                    else if( aa == '*')
                        result = n1 * n2;
                    else if(aa == '-')
                        result = n1 - n2;

                    copy_number.add(i, result);

                    copy_operator.remove(i);
                    copy_number.remove(i+1);
                    copy_number.remove(i+1);
                    num = 0;
                }
                else {
                    num = 1;
                }
            }
        }

        System.out.println("값 : " + copy_number.get(0));

        max = Math.max(max, Math.abs(copy_number.get(0)));
    }

}
