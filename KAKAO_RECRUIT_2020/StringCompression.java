package KAKAO_RECRUIT_2020;

public class StringCompression {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = s.length();

        for(int i=1; i< s.length()/2 +1 ; i++) {
            answer = Math.min(answer, compression(s, i));
        }

        return answer;
    }

    public static int compression(String s, int size) {

        String compression = "";
        String temp = s.substring(0, size);
        int cnt = 1, remain = s.length()%size;

        for(int i = size; i <= s.length() - size ; i += size) {
            String getString = s.substring(i, i+size);

            if(temp.equals(getString)){
                cnt++;
            }else {
                if(cnt == 1)
                    compression += temp;
                else
                    compression = compression + cnt + temp;
                temp = getString;
                cnt = 1;
            }
        }

        if(cnt > 1)
            compression = compression + cnt + temp;
        else
            compression += temp;

        return compression.length() + remain;
    }
}
