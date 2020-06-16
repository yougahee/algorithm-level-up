package level1;

import java.util.ArrayList;

public class MockExam {

    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,5};
        System.out.println(solution(numbers));
    }


    public static int[] solution(int[] answers) {
        int[] result;

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int a_cnt =0;
        int b_cnt =0;
        int c_cnt =0;

        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        //cnt 구해주는 과정
        for(int i=0; i<answers.length; i++) {
            if(a[i%5] == answers[i])
                a_cnt++;
            if(b[i%8] == answers[i])
                b_cnt++;
            if(c[i%10] == answers[i])
                c_cnt++;
        }

        //비교과정
        max = Math.max(a_cnt, Math.max(b_cnt, c_cnt));

        if(max == a_cnt) list.add(1);
        if(max == b_cnt) list.add(2);
        if(max == c_cnt) list.add(3);

        result = new int[list.size()];

        //와,, 방법이 이것밖에 없을까..? 넘나 복잡해지네.,.ㅠ
        for(int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

}
