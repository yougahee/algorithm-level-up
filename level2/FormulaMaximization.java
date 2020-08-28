package level2;

import javax.swing.*;
import java.util.*;

public class FormulaMaximization {

    public static void main(String[] args) {
        String p = "100-200*300-500+20";
        String p1 = "50*6-3*2";

        System.out.println(solution(p));
        System.out.println(solution(p1));
    }

    static long max;
    static String[] opp, output;
    static Queue<Integer> number;
    static Queue<String> operator;

    static Queue<Integer> copy_number;
    static Queue<String> copy_operator;

    static public long solution(String expression) {
        number = new LinkedList<>();
        operator = new LinkedList<>();

        String temp = "";
        Set<String> set = new HashSet<>();

        for(int i=0; i<expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '*':
                    operator.add("*");
                    set.add("*");
                    number.add(Integer.parseInt(temp));
                    temp = "";
                    break;
                case '+':
                    operator.add("+");
                    set.add("+");
                    number.add(Integer.parseInt(temp));
                    temp = "";
                    break;
                case '-':
                    operator.add("-");
                    set.add("-");
                    number.add(Integer.parseInt(temp));
                    temp = "";
                    break;
                default:
                    temp += expression.charAt(i);
                    break;
            }
        }

        int opp_index = 0;
        opp = new String[set.size()];
        output = new String[set.size()];

        for(String i : set) {
            opp[opp_index++] = i;
        }

        boolean[] visited = new boolean[set.size()];

        permutation(opp, output, visited, 0, set.size(), set.size());

        return max;
    }

    static public void permutation(String[] arr, String[] output, boolean[] visited, int depth, int n, int r) {

        if(r == depth){

            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth+1, n, r);
                visited[i] = false;
                output[depth] = "";
            }
        }
    }

    static public void Calculator(String[] Priority) {

        copy_number = number;
        copy_operator = operator;

        long result = 0;
        int size = 0;

        for(String oper : Priority) {

            size = copy_operator.size();

            for(int i=0; i<size; i++) {
                if(oper.equals(copy_operator.peek())) {


                }
                else {
                    copy_operator.add(copy_operator.poll());
                    copy_number.add(copy_number.poll());
                }

            }
        }

        //계산한 값
        max = Math.max(max, result);
    }
}
