package KAKAO_RECRUIT_2020;

public class LockAndKey {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(key, lock));
    }

    static boolean isOpenAnswer = false;
    static int len;

    public static boolean solution(int[][] key, int[][] lock) {
        len = lock.length;

        int[][] copyLock = new int[len*3][len*3];

        for(int i= 0; i<len; i++) {
            for(int j= 0; j<len; j++) {
                copyLock[i + len][j + len] = lock[i][j];
            }
        }

        DFS(key, copyLock);
        return isOpenAnswer;
    }

    public static void DFS(int[][] key, int[][] lock) {
        //rotate 4번 하면 됨.
        for(int i=0; i<4; i++) {
            checkUpDown(key, lock, 0, 0);

            if(isOpenAnswer)
                return;

            //90도 회전
            key = rotateKey(key);
        }
    }

    public static void checkUpDown(int[][] key, int[][] lock, int x, int y) {

        if(y + key.length > lock.length) {
            y=0;
            x++;
        }

        if( x + key.length > lock.length)
            return;

        int[][] copyLock = new int[lock.length][lock.length];

        for(int i=0; i<lock.length; i++)
            copyLock[i] = lock[i].clone();

        for(int i=0; i<key.length; i++) {
            for(int j=0; j<key.length; j++) {
                copyLock[x+i][y+j] = key[i][j] ^ lock[x+i][y+j];
            }
        }

        if(isOpen(copyLock))  {
            isOpenAnswer = true;
            return;
        }

        checkUpDown(key, lock, x, y+1);
    }

    //90도 회전.
    public static int[][] rotateKey(int[][] key) {
        int len = key.length;
        int[][] rotatecopy = new int[len][len];

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                rotatecopy[i][j] = key[len-j-1][i];
            }
        }
        return rotatecopy;
    }

    //끝났는지?!
    public static boolean isOpen(int[][] lock) {
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(lock[i + len][j + len] != 1)
                    return false;
            }
        }
        return true;
    }

    public static void print(int[][] key) {
          //print
        for(int i=0; i<key.length; i++) {
            for(int j=0; j<key.length; j++) {
                System.out.print(key[i][j]);
            }
            System.out.println();
        }
    }
}
