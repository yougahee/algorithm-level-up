package level2;

import java.util.Arrays;

public class RightThatSong {

    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        //String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,AB#CD#EF#"};

        System.out.println(solution(m, musicinfos));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "`(None)`";
        String[] music;
        String real_music = "";

        int maxPlayTime  = 0;

        m = replaceShap(m);

        for(int i=0; i<musicinfos.length; i++) {
            music = musicinfos[i].split(",");

            music[3] = replaceShap(music[3]);

            int real_music_size = (Integer.parseInt(music[1].substring(0, 2)) -
                    Integer.parseInt(music[0].substring(0, 2))) *60
                    + (Integer.parseInt(music[1].substring(3)) -
                    Integer.parseInt(music[0].substring(3)));


            real_music = realMusicString(music[3], real_music_size);

            System.out.println(real_music);

            if(real_music.contains(m)) {
                if(maxPlayTime < real_music_size) {
                    maxPlayTime = real_music_size;
                    answer =  music[2];
                }
            }
        }

        return answer;
    }

    public static String replaceShap(String str) {
        return str.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a");
    }

    public static String realMusicString(String music, int size) {

        String result = "";

        while (result.length() < size) {
            result += music;
        }

        return result.substring(0, size);
    }
}
