package level2;

import java.util.HashSet;

public class CandidateKey {
    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},
                {"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},
                {"600","apeach","music","2"}};

        System.out.println(solution(relation));
    }

    public static int solution(String[][] relation) {
        int answer = 0;

        int rowLen = relation.length;
        int colLen = relation[0].length;

        HashSet<Integer> candidatekey = new HashSet<>();
        HashSet<String> check = new HashSet<>();

        //1 ~ n-1 까지 돌아본다.
        for(int bitset = 1; bitset < (1 << colLen); bitset++) {

            check.clear();

            for(int i=0; i<rowLen; i++) {
                String temp = "";
                for(int j=0; j<colLen; j++) {

                    if( (bitset & (1 << j)) != 0) {
                        temp += relation[i][j] + ",";
                    }
                }
                check.add(temp);
            }

            boolean isRight = true;

            if(check.size() == rowLen) {
                for(int key : candidatekey) {
                    if( ( key & bitset ) == key)
                        isRight = false;
                }

                if(isRight)
                    candidatekey.add(bitset);
            }
        }

        return candidatekey.size();
    }
}
