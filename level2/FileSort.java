package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileSort {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        System.out.println(Arrays.toString(solution(files)));
    }

    static class file implements Comparable<file> {
        String head;
        String number;
        String tail;

        public file(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(file o) {
            int head = this.head.toLowerCase().compareTo(o.head.toLowerCase());

            if (head != 0)
                return head;

            return Integer.parseInt(this.number) - Integer.parseInt(o.number);
        }
    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<file> fileArrayList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String file = files[i];

            int numberIndex = 0, cnt = 1;
            String head, number, tail;

            for (int j = 0; j < file.length(); j++) {
                char a = file.charAt(j);

                if (a >= '0' && a <= '9') {
                    if(numberIndex == 0)
                        numberIndex = j;
                    else
                        cnt++;
                }
                else {
                    if(numberIndex != 0)
                        break;
                }
            }

            head = file.substring(0, numberIndex);
            number = file.substring(numberIndex, numberIndex+cnt);
            tail = file.substring(numberIndex+cnt);

            fileArrayList.add(new file(head, number, tail));
        }

        Collections.sort(fileArrayList);

        for(int i=0; i<fileArrayList.size(); i++) {
            answer[i] = fileArrayList.get(i).head +
                    fileArrayList.get(i).number+
                    fileArrayList.get(i).tail;
        }

        return answer;
    }
}
