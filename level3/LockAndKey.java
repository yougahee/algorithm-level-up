package level3;

public class LockAndKey {
    public static void main(String[] args) {

        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(key, lock));
    }

    static boolean isOK = false;

    public static boolean solution(int[][] key, int[][] lock) {

        int len = lock.length;

        int[][] copyLock = new int[len*3][len*3];

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                copyLock[i+len][j+len] = lock[i][j];
            }
        }

       /* //print
        for(int i=0; i<len*3; i++) {
            for(int j=0; j<len*3; j++) {
                System.out.print(copyLock[i][j]);
            }
            System.out.println();
        }*/

        dfs(key, copyLock, 0);

        return isOK;
    }

    public static void dfs(int[][] key, int[][] lock, int cnt) {
        check(key, lock, 0,0);

        if(isOK) return;
        if(cnt >= 4) return;
        //90도 움직이기
        int[][] temp =  rotate(key);
        dfs(temp, lock, cnt+1);
    }

    public static void check(int[][] key, int[][] lock, int x, int y) {
        if(isOK) return;
        if(y + key.length > lock.length){
            y = 0;
            x++;
        }
        if(x + key.length > lock.length) return;

        int[][] copyLock = new int[lock.length][lock.length];

        for(int i=0; i<lock.length; i++)
            copyLock[i] = lock[i].clone();


        for(int i=0; i<key.length; i++) {
            for(int j=0; j<key.length; j++) {
                copyLock[i+x][j+y] = key[i][j] ^ lock[i+x][j+y];
            }
        }

        if(isOpen(copyLock))
            isOK = true;

        check(key, lock, x, y+1);
    }

    //가운데 lock의 부분이 모두다 채워졌는지 확인하는 함수
    public static boolean isOpen(int[][] lock) {
        int len = lock.length/3;

        for(int i=len; i<len*2; i++) {
            for(int j=len; j<len*2; j++) {
                if(lock[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    //시계방향으로 90도 옮기기
    public static int[][] rotate(int[][] key) {
        int len = key.length;
        int[][] temp = new int[len][len];

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                temp[i][j] = key[len-j-1][i];
            }
        }
        return temp;
    }
}
