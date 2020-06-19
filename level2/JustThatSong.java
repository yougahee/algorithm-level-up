package level2;

import java.util.ArrayList;

public class JustThatSong {

    public static void main(String[] args) {
        String m = "ABC#";
        //String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,AB#CD#EF#"};

        System.out.println(solution(m, musicinfos));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        String streamingMusic = "";
        int time;

        ArrayList<String> musicTitle = new ArrayList<>();
        ArrayList<Integer> musicPlayTime = new ArrayList<>();

        //# 제거
        m = replaceShap(m);

        for(int i=0; i<musicinfos.length; i++) {
            String[] str = musicinfos[i].split(",");

            //#제거
            str[3] = replaceShap(str[3]);

            //총 걸린 시간
            time = timetoInt(str[1]) - timetoInt(str[0]);

            //실제로 노래가 play된 것
            streamingMusic = musicPlay(str[3], time);

            if(streamingMusic.contains(m))
            {
                musicTitle.add(str[2]);
                musicPlayTime.add(time);
            }
        }

        int max;

        if(musicTitle.isEmpty())
            return "(None)";
        else{
            answer = musicTitle.get(0);
            max = 0;

            for(int i=0; i<musicTitle.size(); i++) {
                if(max < musicPlayTime.get(i))
                {
                    max = musicPlayTime.get(i);
                    answer = musicTitle.get(i);
                }
            }
        }

        return answer;
    }

    public static int timetoInt (String time) {
        String[] divideTime = time.split(":");
        int hour = Integer.parseInt(divideTime[0]);
        int minute = Integer.parseInt(divideTime[1]);

         return hour * 60 + minute;
    }

    public static String musicPlay(String musicInfo, int time) {

        int size = musicInfo.length();
       // System.out.println("musicInfo's SIZE  " + size);
      //  System.out.println("time " + time);

        StringBuilder sb = new StringBuilder();

        while (sb.length() + size < time) {
            sb.append(musicInfo);
        }

        if(sb.length() != time){
            String input = musicInfo.substring(0, time - sb.length());
            sb.append(input);
        }

        return sb.toString();
    }

    //#이 들어가 있는 친구들 바꾸기 A#, C#, D#, F#, G#
    public static String replaceShap(String str) {

        str = str.replaceAll("A#", "K");
        str = str.replaceAll("C#", "Z");
        str = str.replaceAll("D#", "X");
        str = str.replaceAll("F#", "Y");
        str = str.replaceAll("G#", "T");

        return str;
    }


}
