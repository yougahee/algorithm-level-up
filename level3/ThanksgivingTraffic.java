package level3;

public class ThanksgivingTraffic {
    public static void main(String[] args) {
        String[] lines = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };

        System.out.println(solution(lines));
    }

    public static int solution(String[] lines) {
        int answer = 0, cnt;

        int[] startTime = new int[lines.length];
        int[] endTime = new int[lines.length];

        changeMillisecond(lines, startTime, endTime);

        //startTime에 걸쳐있는 아이들 구하기
        for(int i=0; i<lines.length; i++) {
            cnt =0;
            int startSection = startTime[i];
            int endSection = startSection + 1000;

            for(int j=0; j<lines.length; j++) {
                if(startTime[j] >= startSection && startTime[j] < endSection)
                    cnt++;
                else if(endTime[j] >= startSection && endTime[j] < endSection)
                    cnt++;
                else if(startTime[j] <= startSection && endTime[j] >= endSection)
                    cnt++;
            }

            answer = Math.max(cnt, answer);
        }

        //endTime에 걸쳐있는 아이들 구하기
        for(int i=0; i<lines.length; i++) {
            cnt =0;
            int startSection = endTime[i];
            int endSection = startSection + 1000;

            for(int j=0; j<lines.length; j++) {
                if(startTime[j] >= startSection && startTime[j] < endSection)
                    cnt++;
                else if(endTime[j] >= startSection && endTime[j] <endSection)
                    cnt++;
                else if(startTime[j] <= startSection && endTime[j] >= endSection)
                    cnt++;
            }

            answer = Math.max(cnt, answer);
        }


        return answer;
    }

    public static void changeMillisecond(String[] original, int[] startTime, int[] endTime) {
        String[] temp, time;

        for(int i=0; i<original.length; i++) {
            temp = original[i].split(" ");
            int duringTime = (int) (Double.parseDouble(temp[2].replace("s", "")) * 1000 );

            time = temp[1].split(":");
            int milliSecondsEndTime = (int) ((Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60 +
                    Double.parseDouble(time[2])) * 1000);
            int milliSecondsStartTime = milliSecondsEndTime - duringTime + 1;

            startTime[i] = milliSecondsStartTime;
            endTime[i] = milliSecondsEndTime;
        }
    }
}
