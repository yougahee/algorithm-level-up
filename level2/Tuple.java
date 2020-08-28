package level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Tuple {

    public static void main(String[] args) {
        String p = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String p1 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String p2 = "{{20,111},{111}}";
        String p3 = "{{123}}";
        String p4 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";


        System.out.println(Arrays.toString(solution(p)));
        System.out.println(Arrays.toString(solution(p1)));
        System.out.println(Arrays.toString(solution(p2)));
        System.out.println(Arrays.toString(solution(p3)));
        System.out.println(Arrays.toString(solution(p4)));


        System.out.println(Arrays.toString(othersolution(p2)));
        System.out.println(Arrays.toString(othersolution(p3)));

    }

    //가희 코드
    static public int[] solution(String s) {
        int[] answer = {};

        String[] temp = s.substring(1, s.length()-1).split("},");
        String[][] tuple = new String[temp.length][];

        HashSet<Integer> hashSet = new HashSet<>();

        answer = new int[temp.length];
        int[] size = new int[temp.length+1];

        for(int i=0; i<temp.length; i++) {

            temp[i] = temp[i].replace("{", "").replace("}", "");
            tuple[i] = temp[i].split(",");

            size[tuple[i].length] = i;
        }

        int answer_index =0;

        for(int i=1; i<size.length; i++) {
            int tuple_x = size[i];
            for(int j = 0; j< i; j++) {
                int index = Integer.parseInt(tuple[tuple_x][j]);

                if(hashSet.add(index)) {
                    answer[answer_index++] = index;
                }
            }
        }
        return answer;
    }


    //배울만한 코드
    static public int[] othersolution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");

        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}
