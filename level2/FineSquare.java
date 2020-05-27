package level2;

public class FineSquare {
    public static void main(String[] args) {

        System.out.println(solution(8,12));
    }


    public static long solution(int w, int h) {
        long answer = w*h;

        //정사각형
        if(w == h)
            return answer - w;



        if(w-h > 0) {
            int a =w/h;
            answer -= (a+1) * h;
        }else{
            int a =h/w;
            answer -= (a+1) * w;
        }

        return answer;
    }
}

