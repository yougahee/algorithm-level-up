package level3;

import java.util.Arrays;

public class ExteriorWallInspection {
    public static void main(String[] args) {
        int n = 12;
        int[] week = {1,5,6,10};
        int[] dist = {1,2,3,4};

        System.out.println(solution(n, week, dist));
    }

    static int[] isCheckedWeak;
    static int nSize;
    static int[] weakS, distS;

    public static int solution(int n, int[] weak, int[] dist) {
        int mincount = 0;
        boolean isAnswer = false;

        isCheckedWeak = new int[202];
        nSize = n;
        weakS = weak;

        Arrays.sort(dist);

        for(int i=0; i<weak.length; i++) {
            isCheckedWeak[weak[i]] = -1;
        }

        System.out.println(Arrays.toString(isCheckedWeak));

        for(int i = dist.length-1; i >= 0; i--) {
            int moveSize = dist[i];
            int max = 0, direction =0, maxStart=0;

            System.out.println("이동 거리 :  " + moveSize);

            for(int j=0; j<weak.length; j++) {
                System.out.println("j : " + j + "  -1이냐? : " + isCheckedWeak[weak[j]]);

                if(isCheckedWeak[weak[j]] == -1) {
                    int cntR = 0, cntL = 0;
                    int start = weak[j];

                    //시계방향
                    for(int k = 1; k <= moveSize; k++) {
                        if( isCheckedWeak[(start + k) % nSize] == -1 )
                            cntR++;
                    }
                    if(max < cntR) {
                        max = cntR;
                        maxStart = start;
                        direction = 0;
                    }


                    //반시계방향
                    for(int k = 1; k <= moveSize; k++) {
                        if( isCheckedWeak[(start - moveSize + nSize) % nSize] == -1 )
                            cntL++;
                    }

                    if(max < cntL) {
                        max = cntL;
                        maxStart = start;
                        direction = 1;
                    }
                }
            }

            System.out.println("na");
            //실제로 적용을 시켜라,,
            apply(maxStart, direction, moveSize);
            mincount++;

            //취약점을 다 체크했으면 끝내라!
            if(isAllChecked()) {
                isAnswer = true;
                break;
            }
        }

        if(isAnswer)
            return mincount;
        else
            return -1;
    }

    public static void apply(int start, int direction, int size) {
        //시계
        if(direction == 0) {
            for(int k = 1; k <= size; k++) {
                if( isCheckedWeak[(start + k) % nSize] == -1 )
                    isCheckedWeak[ (start + k) % nSize ] = 1;
            }
        }
        //반시계
        else {
            for(int k = 1; k <= size; k++) {
                if( isCheckedWeak[(start - size + nSize) % nSize] == -1 )
                    isCheckedWeak[(start - size + nSize) % nSize] = 1;
            }
        }
    }

    public static boolean isAllChecked() {

        for(int i=0; i<weakS.length; i++) {
            if(isCheckedWeak[weakS[i]] == -1)
                return false;
        }
        return true;
    }
}
