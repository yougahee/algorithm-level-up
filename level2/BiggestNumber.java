package level2;

import java.util.Arrays;

public class BiggestNumber {

    public static void main(String[] args) {
        int[] heights = {6, 10, 2};

        System.out.println(solution(heights));
    }

    public static String solution(int[] numbers) {
        StringBuilder answer  = new StringBuilder();

        String[] num = new String[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }

        //string으로 변환해준 첫번째 값들로 sort한 후,
        // compare을 통해 뒤에 있는 것들을 자동?으로 비교해서 알아서 위치를 정해줌..와우!
        //너무나 간단..
        Arrays.sort(num, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));


        //0밖에 없는 배열이면 0만을 호출!
        if(num[0].startsWith("0")) {
            return "0";
        }

        for(int i=0; i<numbers.length; i++) {
            answer.append(num[i]);
        }


        return answer.toString();
    }
}

