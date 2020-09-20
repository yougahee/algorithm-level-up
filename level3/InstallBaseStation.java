package level3;


public class InstallBaseStation {
    public static void main(String[] args) {
        int[] stations = {4, 11};
        System.out.println(solution(11, stations, 1) );

        int[] station = {1};
        System.out.println(solution(3, station, 2) );
    }

    //중간의 if절 부분 예외를 생각하지 못함
    //소요시간 : 1시간
    //binarySearch를 생각했지만, middle의 조건을 어떻게 달아야할지 몰라 하드코딩 같은 느낌쓰..
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int left, right, area = 2*w+1;

        //처음
        if(stations[0] - w - 1 > 0) {
            left = 1;
            right = stations[0] - w - 1;
            answer += install5G(left, right, area);
        }

        //중간
        for(int i=0; i<stations.length-1; i++) {
            left = stations[i] + w + 1;
            right = stations[i+1] - w -1;

            if(left > right)
                continue;
            answer += install5G(left, right, area);
        }

        //끝
        if(stations[stations.length-1] + w + 1 <= n) {
            left = stations[stations.length-1] + w + 1;
            right = n;
            answer += install5G(left, right, area);
        }

        return answer;
    }

    public static int install5G(int left, int right, int area) {
        int cnt = 1, w = right - left + 1, areaC = area;

        while (w > area) {
            cnt++;
            area = areaC*cnt;
        }

        return cnt;
    }
}
