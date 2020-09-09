package level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class JewelryShopping {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};

        System.out.println(Arrays.toString(solution(gems)));
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int start=0, end=0;
        int minSize = Integer.MAX_VALUE;

        HashSet<String> kindgems = new HashSet<>();
        HashMap<String, Integer> temp = new HashMap<>();

        for(String gem : gems) {
            kindgems.add(gem);
        }


        for(int i=0; i<gems.length; i++) {

            temp.put(gems[i], i);

            if(kindgems.size() == temp.size()) {
                int s = Integer.MAX_VALUE, e = Integer.MIN_VALUE;
                for(Integer num : temp.values()) {
                    System.out.println(num);
                    s = Math.min(s, num);
                    e = Math.max(e, num);
                }

                if(e-s < minSize) {
                    start = s;
                    end = e;
                    minSize = e-s;
                }

                temp.remove(gems[s]);

            }
        }

        answer[0] = start+1;
        answer[1] = end +1;

        return answer;
    }



    //시간초과..
   /* public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int kindSize =0;
        int start=0, end=0, middle= Integer.MAX_VALUE;

        HashSet<String> kindgems = new HashSet<>();
        HashSet<String> temp = new HashSet<>();

        for(String gem : gems) {
            kindgems.add(gem);
        }

        kindSize = kindgems.size();

        for(int i=0; i<= gems.length-kindSize; i++) {
            System.out.println("================");
            System.out.println("i : " + i);
            temp.clear();
            for(int j = i; j<gems.length; j++){
                temp.add(gems[j]);

                System.out.println("첫 첫첫 " + "i : " + i + " j : " + j + " middle : " + middle);

                if(j-i > middle)
                    break;

                if(temp.size() == kindSize) {
                    if( j - i < middle) {
                        start = i;
                        end = j;
                        middle = end - start;
                        System.out.println("i : " + i + " j : " + j + " middle : " + middle);
                    }
                    break;
                }
            }
        }

        answer[0] = start+1;
        answer[1] = end+1;
        return answer;
    }*/


}
