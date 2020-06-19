package level3;

public class RepresentedByN {
    public static void main(String[] args) {

        int N = 5;
        int number = 12;


        int N2 = 2;
        int number3 = 11;

        System.out.println(solution(N, number));
        //System.out.println(solution(N2, number3));
    }

    public static int solution(int N, int number) {
        int answer = -1;

        System.out.println('1' + '1');

        //1인경우
        if(N == number)
            return 1;
        //2인경우
        if(N+N == number || number == 1 || number == N * N)
            return 2;

        for(int i=3; i<9; i++) {

        }



        return answer;
    }
}
