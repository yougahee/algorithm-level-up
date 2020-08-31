package level1;

public class KeyPad {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        System.out.println(solution(numbers, hand));
    }

    static public String solution(int[] numbers, String hand) {
        String answer = "";
        int left_x = 4, left_y = 1;
        int right_x = 4, right_y = 3;
        int num_x, num_y = 2;

        for(int number : numbers) {
            if(number == 1 || number == 4 || number == 7) {
                answer += "L";
                left_x = number/3+1;
                left_y = 1;
            }
            else if(number == 3 || number == 6 || number == 9) {
                answer += "R";
                right_x = number/3;
                right_y = 3;
            }
            else {
                //number == 0 이면
                if(number == 0)
                    num_x = 4;
                else
                    num_x = number/3+1;

                //거리비교
                int distance_L = Math.abs(left_x - num_x) + Math.abs(left_y - num_y);
                int distance_R = Math.abs(right_x - num_x) + Math.abs(right_y - num_y);

                if(distance_L == distance_R){
                    if(hand.equals("right")){
                        answer += "R";
                        right_x = num_x;
                        right_y = num_y;
                    }
                    else {
                        answer += "L";
                        left_x = num_x;
                        left_y = num_y;
                    }

                }else if(distance_L > distance_R){
                    answer += "R";
                    right_x = num_x;
                    right_y = num_y;
                }
                else {
                    answer += "L";
                    left_x = num_x;
                    left_y = num_y;
                }
            }

           // System.out.println("number : " + number + " answer : " + answer);
           // System.out.println("left_x : " + left_x + " left_y : " + left_y);
           // System.out.println("right_x : " + right_x + " right_y : " + right_y);

        }

        return answer;
    }

}
