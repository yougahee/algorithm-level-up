package level2;

import java.util.ArrayList;

public class NewsClustering {
    public static void main(String[] args) {

        String str1 = "FRANCE";
        String str2 = "french";
        System.out.println(solution(str1, str2));

        String str11 = "aa1+aa2";
        String str22 = "AAAA12";
        System.out.println(solution(str11, str22));

        String str111 = "handshake";
        String str222 = "shake hands";
        System.out.println(solution(str111, str222));
    }

    public static int solution(String str1, String str2) {
        int answer = 65536;

        int Intersection = 0, union, cnt=0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> arrayStr1 = new ArrayList<>();
        ArrayList<String> arrayStr2 = new ArrayList<>();

        insertArrayList(str1, arrayStr1);
        insertArrayList(str2, arrayStr2);

        union = arrayStr1.size() + arrayStr2.size();

        if(union == 0)
            return answer;

        String a1, a2;
        //교집합 구하기
        for(int i=0; i<arrayStr1.size(); i++) {
            for(int j=0; j<arrayStr2.size(); j++) {
                a1 = arrayStr1.get(i);
                a2 = arrayStr2.get(j);
                if( !a1.equals("0") && !a2.equals("0") && a1.equals(a2)) {
                    arrayStr1.remove(i);
                    arrayStr2.remove(j);
                    //arrayStr1.add(i,"0");
                    //arrayStr2.add(j, "0");
                    i--;
                    Intersection++;
                    break;
                }
            }
        }

        //합집합 = 전체개수 - 교집한 수
        union -= Intersection;

        return answer * Intersection / union;
    }

    public static void insertArrayList(String str, ArrayList<String> arrayList) {
        String temp = "";

        for(int i=0; i<str.length()-1; i++) {

            char n1 = str.charAt(i);
            char n2 = str.charAt(i+1);

            if(n1 >='a' && n1 <= 'z' && n2 >='a' && n2 <= 'z'){
                temp += n1;
                temp += n2;
                arrayList.add(temp);
                temp = "";
            }
        }
    }
}
