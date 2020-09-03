package level1;

public class DartGame {
    public static void main(String[] args) {

        String dartResult = "1S2D*3T";

        System.out.println(solution(dartResult));

    }

    public static int solution(String dartResult) {
        int[] bonus = new int[3];
        int start = 0, index =0;

        //옵션은 무조건 하나

        for(int i=0; i<dartResult.length(); i++) {
            char dart = dartResult.charAt(i);

            if(dart == 'S' || dart == 'D' || dart == 'T') {
                bonus[index] = Integer.parseInt(dartResult.substring(start, i));
                calBonus(bonus, dart, index);
                start = i+1;

                //뒤에 나오는게 *이나 #인지 확인
                if(i+1 < dartResult.length() ){
                    if(dartResult.charAt(i+1) == '*' || dartResult.charAt(i+1) == '#'){
                        calOption(bonus, dartResult.charAt(i+1), index);
                        start++;
                    }
                }
                index++;
            }
        }

        return bonus[0] + bonus[1] + bonus[2];
    }

    public static void calBonus(int[] bonus, char area, int index) {
        int x = bonus[index];

        switch (area) {
            case 'D':
                bonus[index] = x * x;
                break;
            case 'T':
                bonus[index] = x * x * x;
                break;
        }
    }

    public static void calOption(int[] bonus, char area, int index) {
        int x = bonus[index];

        switch (area) {
            case '*':
                if(index != 0)
                    bonus[index-1] *= 2;

                bonus[index] = x * 2;
                break;
            case '#':
                bonus[index] = x * (-1);
                break;
        }
    }
}
