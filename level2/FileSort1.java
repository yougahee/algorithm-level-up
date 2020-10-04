package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileSort1 {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        System.out.println(Arrays.toString(solution(files)));
    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<File> arrayList = new ArrayList<>();

        for(int i=0; i<files.length; i++) {
            int startNumIdx =0, endNumIdx=files[i].length();

            for(int j=0; j< files[i].length(); j++) {
                if(startNumIdx == 0 && files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9') {
                    startNumIdx = j;
                }

                //숫자가 아닐때.
                if(startNumIdx !=0 && (files[i].charAt(j) < '0' || files[i].charAt(j) > '9')) {
                    endNumIdx = j;
                    break;
                }
            }
            String head = files[i].substring(0, startNumIdx);
            String number = files[i].substring(startNumIdx, endNumIdx);
            String tail = "";
            if(endNumIdx != files[i].length())
                tail = files[i].substring(endNumIdx);

            arrayList.add(new File(i, head, number, tail));
        }

        Collections.sort(arrayList);

        for(int i =0; i<files.length; i++)
            answer[i] = files[arrayList.get(i).index];

        return answer;
    }

    public static class File implements Comparable<File>{
        int index;
        String head;
        String number;
        String tail;

        File(int index, String head, String number, String tail) {
            this.index = index;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(File o) {
            int headSize = this.head.toLowerCase().compareTo(o.head.toLowerCase());

            if(headSize == 0)
                return Integer.parseInt(this.number) - Integer.parseInt(o.number);

            return headSize;
        }
    }
}
