package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TravelRoute {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        System.out.println(Arrays.toString(solution(tickets)));
    }

    static int[] isVisited;
    static String route = "";
    static ArrayList<String> arrayList = new ArrayList<>();

    public static String[] solution(String[][] tickets) {

        for(int i=0; i<tickets.length; i++) {
            isVisited = new int[tickets.length];

            String start = tickets[i][0];
            String end = tickets[i][1];

            if(start.equals("ICN")) {
                route = start + ",";
                isVisited[i] =1;
                DFS(tickets, end, 1);
            }
        }

        Collections.sort(arrayList);
        String[] answer = arrayList.get(0).split(",");

        return answer;
    }

    public static void DFS(String[][] tickets, String end, int cnt) {
        route += end + ",";

        if(cnt == tickets.length) {
            arrayList.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++) {
            if(isVisited[i] == 0 && tickets[i][0].equals(end)) {
                isVisited[i] =1;
                DFS(tickets, tickets[i][1], cnt+1);
                isVisited[i] =0;
                route = route.substring(0, route.length()-4);
            }
        }
    }
}
