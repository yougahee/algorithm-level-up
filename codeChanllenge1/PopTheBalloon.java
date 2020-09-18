package codeChanllenge1;

public class PopTheBalloon {
    public static void main(String[] args) {
        int[] a = {9,-1,-5};
        //System.out.println(solution(a));

        int[] a1 = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        System.out.println(solution(a1));
    }

    static int lefSmall=0;
    static int[] rightMin;

    //프로그래머스 열리면 한번 실행해보기
    public static int solution(int[] a) {
        int cnt =2;

        //right판단하기
        rightMin = new int[a.length];

        for(int i= a.length-1; i>=0; i--) {
            if(i == a.length-1)
                rightMin[i] = a[i];
            else
                rightMin[i] = Math.min(a[i], rightMin[i+1]);
        }

        for(int i=1; i<a.length-1; i++) {
            int left = isLeftSmall(i, a);
            int right = isRightSmall(i, a);

            if(left + right <= 1)
                cnt++;
        }

        return cnt;
    }

    public static int isLeftSmall(int index, int[] a) {
        int x = a[index];

        if(a[lefSmall] < x)
            return 1;
        else {
            lefSmall = index;
            return 0;
        }
    }

    public static int isRightSmall(int index, int[] a) {
        int x = a[index];

        if(rightMin[index+1] < x)
            return 1;
        return 0;
    }
}
