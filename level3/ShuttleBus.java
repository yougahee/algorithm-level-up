package level3;

import java.util.ArrayList;
import java.util.Collections;

public class ShuttleBus {

    public static void main(String[] args) {
        //case1
        int n = 1, t = 1, m = 5;
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
        System.out.println(solution(n, t, m, timetable));

        //case2
        int n1 = 2, t1 = 10, m1 = 2;
        String[] timetable1 = {"09:10", "09:09", "08:00"};
        System.out.println(solution(n1, t1, m1, timetable1));

        //case3
        int n2 = 2, t2 = 1, m2 = 2;
        String[] timetable2 = {"09:00", "09:00", "09:00", "09:00"};
        System.out.println(solution(n2, t2, m2, timetable2));
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int startTime = 9 * 60;
        int busStartTime=0, lastPeopleWaitTime=0;
        boolean spareSeat = false;
        //콘이 꼭 타야하는 버스 시간
        int con = startTime + n * t;

        ArrayList<Integer> peopleWaitTime = new ArrayList<>();

        for (int i = 0; i < timetable.length; i++) {
            String temp = timetable[i];
            int time = Integer.parseInt(temp.substring(0, 2)) * 60 + Integer.parseInt(temp.substring(3));
            peopleWaitTime.add(time);
        }

        Collections.sort(peopleWaitTime);

        loop:
        for (int i = 0; i < n; i++) {
            busStartTime = startTime + t * i;
            //System.out.println("버스 출발 시간 : " + busStartTime/60 + " : " + busStartTime%60);

            for(int j=0; j < m; j++) {
                if (peopleWaitTime.size() == 0) {
                    spareSeat = true;
                    break loop;
                }

                lastPeopleWaitTime = peopleWaitTime.get(0);

                if (busStartTime >= lastPeopleWaitTime) {
                    //System.out.println("이 사람은 탑니다. : " + printTime(lastPeopleWaitTime));
                    peopleWaitTime.remove(0);
                }
            }
        }

        //자리가 비어있음..
        if(spareSeat){
            answer = printTime(busStartTime);
        }else {
            if(lastPeopleWaitTime <= busStartTime){
                answer = printTime(lastPeopleWaitTime-1);
            }else{
                answer = printTime(busStartTime);
            }
        }

        return answer;
    }

    public static String printTime(int time){
        return String.format("%02d:%02d", time/60 ,time%60);
    }
}
