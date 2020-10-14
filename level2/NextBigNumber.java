package level2;

public class NextBigNumber {
    public static void main(String[] args) {

    }

    public int solution(int n) {
        int answer = n+1, ansCnt = -1;
        int nCnt = binaryOneCnt(n);

        while (nCnt != ansCnt) {
            ansCnt = binaryOneCnt(answer);
            answer++;
        }

        return answer;
    }

    public int binaryOneCnt (int n) {
        int cnt = 0;

        String temp = Integer.toBinaryString(n);

        for(char a : temp.toCharArray()) {
            if(a == '1')
                cnt++;
        }

        return cnt;
    }
}
