package level2;

public class FineSquare {
    public static void main(String[] args) {

        System.out.println(solution(8,12));
    }

    public static long solution(int w, int h) {
        long answer = (long) w * h;
        long max = (long) w;
        long min = (long) h;
        long value =1;

        if(w < h) {
            max = h;
            min = w;
        }

        //최대공약수 찾기
        while (value > 0) {
            value = max%min;
            max = min;
            min = value;
        }

        answer -= (h/max + w/max -1) * max;

        return answer;
    }
}

