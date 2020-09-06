package level3;

import java.util.HashSet;

public class FindRoad {
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        System.out.println(solution(user_id, banned_id));
    }

    static HashSet<Integer> answer;
    static int[][] candidate;
    static int size;
    static int[] num;
    static boolean[] visited;

    public static int solution(String[] user_id, String[] banned_id) {
        size = banned_id.length;
        candidate = new int[banned_id.length][user_id.length];
        num = new int[size];
        visited = new boolean[user_id.length];
        answer = new HashSet<>();


        for (int i = 0; i < banned_id.length; i++) {
            String banner = banned_id[i];
            int index = 0;
            int numSize=0;

            for (int j=0; j<user_id.length; j++) {
                String user = user_id[j];
                if (findBannerId(user, banner)) {
                    candidate[i][index++] = j;
                    numSize++;
                }
            }
            num[i] = numSize;
        }

        System.out.println();

        //print candidate
        /*for (int i = 0; i < banned_id.length; i++) {
            for (int j = 0; j < user_id.length; j++) {
                System.out.print(candidate[i][j]);
            }
            System.out.println();
        }*/

        DFS(0,0);

        return answer.size();
    }

    public static boolean findBannerId(String user, String banner) {


        if (user.length() == banner.length()) {
            for (int i = 0; i < user.length(); i++) {
                char userChar = user.charAt(i);
                char bannerChar = banner.charAt(i);

                if (bannerChar != '*' && userChar != bannerChar)
                    return false;
            }
        } else
            return false;

        return true;
    }

    public static void DFS(int depth, int bit) {
        if(size == depth) {
            //1읙 개수를 검사하고 그게 size만큼 있으면 hashset에 넣고
            answer.add(bit);
            return;
        }

        for(int i=0; i<num[depth]; i++) {
            if(!visited[candidate[depth][i]]) {
                visited[candidate[depth][i]] = true;
                //비트부분을 어떻게 처리를 해야할까?!
                DFS(depth+1, bit | 1 << candidate[depth][i]);
                visited[candidate[depth][i]] = false;
            }

        }
    }
}
