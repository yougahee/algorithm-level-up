package level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = {{0,3}, {1,9}, {2,6}};

        System.out.println(solution(jobs));
    }

    static public class Pair {
        int start, during;

        public Pair(int start, int during) {
            this.start = start;
            this.during = during;
        }
    }

    //하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
    // 이 조건대로 풀면 테스트가 8, 18 번 틀리게 나옴. -> 이건 문제잘못이라고 다들 지적
    public static int solution(int[][] jobs) {
        int answer = 0, cnt=1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int processTime =  o1.during - o2.during;

                if(processTime == 0)
                    return o1.start - o2.start;
                return processTime;
            }
        });

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int nowTime = 0;
        pq.add(new Pair(jobs[0][0], jobs[0][1]));

        for(int i=0; i<jobs.length; i++){
            Pair pair = pq.poll();

            //처음 들어왔거나, 중간에 공백이 있었거나 대기시간이 없거나
            if(nowTime <= pair.start) {
                nowTime = pair.start + pair.during;
                answer += pair.during;
            }
            else {
                answer += ( nowTime- pair.start ) + pair.during;
                nowTime += pair.during;
            }

            while (true) {
                if(cnt >= jobs.length) break;
                if(jobs[cnt][0] > nowTime) {
                    if(pq.isEmpty()) {
                        pq.add(new Pair(jobs[cnt][0], jobs[cnt][1]));
                        cnt++;
                    }
                    break;
                }

                pq.add(new Pair(jobs[cnt][0], jobs[cnt][1]));
                cnt++;
            }
        }


        return answer/jobs.length;
    }
}
