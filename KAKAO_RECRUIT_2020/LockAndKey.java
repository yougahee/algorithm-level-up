package KAKAO_RECRUIT_2020;

import java.util.HashSet;

public class LockAndKey {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(key, lock));
    }

    static boolean isOpenAnswer = false;
    static HashSet<String> hashSet;

    public static boolean solution(int[][] key, int[][] lock) {
        hashSet = new HashSet<>();
        String add = "";
        for(int i=0; i<key.length; i++)
            add += '0';
        hashSet.add(add);

        BFS(key, lock);
        return isOpenAnswer;
    }

    public static void BFS(int[][] key, int[][] lock) {
        int lockSize = lock.length;
        int keySize = key.length;
        int[][] copyLock;

        //key와 lock을 비교해서 잘 맞춰지는지?!
        //잘 맞춰지면 isOpenAnswer true -> return
        //아니면 isOpenAnswer false -> return
        for(int i=0; lockSize >= i + keySize; i++) {
            for(int j=0; lockSize >= j+ keySize; j++) {
                //System.out.println("시작 x : " + i + " 시작 y : " + j);
                copyLock = copyArr(key, lock, i, j);

                if(isOpen(copyLock)) {
                    isOpenAnswer = true;
                    return;
                }
            }
        }

        int[][] newKey = new int[keySize][keySize];

        //90도 회전
        newKey = rotateKey(key);

        String temp = toStringValue(newKey);
        if(!hashSet.contains(toStringValue(newKey))) {
            hashSet.add(temp);
            BFS(newKey, lock);
        }

        //상
        newKey = upKey(key);
        temp = toStringValue(newKey);
        if(!hashSet.contains(toStringValue(newKey))) {
            hashSet.add(temp);
            BFS(newKey, lock);
        }

        //하
        newKey = downKey(key);
        temp = toStringValue(newKey);
        if(!hashSet.contains(toStringValue(newKey))) {
            hashSet.add(temp);
            BFS(newKey, lock);
        }

        //좌
        newKey = leftKey(key);
        temp = toStringValue(newKey);
        if(!hashSet.contains(toStringValue(newKey))) {
            hashSet.add(temp);
            BFS(newKey, lock);
        }

        //우
        newKey = rightKey(key);
        temp = toStringValue(newKey);
        if(!hashSet.contains(toStringValue(newKey))) {
            hashSet.add(temp);
            BFS(newKey, lock);
        }
    }

    public static int[][] copyArr(int[][] key, int[][] lock, int x, int y) {
        int[][] lockCopy = new int[lock.length][lock.length];

        for(int i=0; i<key.length; i++) {
            for(int j=0; j<key.length; j++) {
                lockCopy[x+i][y+j] = key[i][j] ^ lock[x+i][y+j];
            }
        }

        return lockCopy;
    }

    public static int[][] rotateKey(int[][] key) {
        int len = key.length;
        int[][] rotatecopy = new int[len][len];

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                rotatecopy[i][j] = key[j][len-i-1];
            }
        }
        return rotatecopy;
    }

    public static int[][] upKey(int[][] key) {
        int len = key.length;
        int[][] up = new int[len][len];

        for(int i=0; i<len-1; i++) {
            for(int j=0; j<len; j++) {
                up[i][j] = key[i+1][j];
            }
        }
        return up;
    }

    public static int[][] downKey(int[][] key) {
        int len = key.length;
        int[][] down = new int[len][len];

        for(int i=0; i<len-1; i++) {
            for(int j=0; j<len; j++) {
                down[i+1][j] = key[i][j];
            }
        }
        return down;
    }

    public static int[][] rightKey(int[][] key) {
        int len = key.length;
        int[][] right = new int[len][len];

        for(int i=len-1; i>0; i--) {
            for(int j=0; j<len; j++) {
                right[j][i] = key[j][i-1];
            }
        }
        return right;
    }

    public static int[][] leftKey(int[][] key) {
        int len = key.length;
        int[][] left = new int[len][len];

        for(int i=0; i<len-1; i++) {
            for(int j=0; j<len; j++) {
                left[j][i] = key[j][i+1];
            }
        }
        return left;
    }

    public static String toStringValue(int[][] key) {
        int len = key.length;
        String temp = "";

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                temp += Integer.toString(key[i][j]);
            }
        }

        return temp;
    }

    public static boolean isOpen(int[][] lock) {
        for(int i=0; i<lock.length; i++) {
            for(int j=0; j<lock.length; j++) {
                if(lock[i][j] != 1)
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
