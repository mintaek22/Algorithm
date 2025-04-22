package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 해킹_10282 {

    /**\
     * a가 b의 의존시 b감염->a감염
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T -- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Edge>> edgeList = new ArrayList<>();
            for (int i = 0; i < n+1; i++) edgeList.add(new ArrayList<>());

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                edgeList.get(b).add(new Edge(a,s));
            }

            int[] time = new int[n+1];
            Arrays.fill(time,Integer.MAX_VALUE);

            PriorityQueue<Edge> q = new PriorityQueue<>((a,b) -> a.time-b.time);
            q.add(new Edge(c,0));
            while(!q.isEmpty()){
                Edge cur = q.poll();

                //이전보다 더 오래 걸리거나 같으면 필요 없다.
                if(cur.time>=time[cur.end]) continue;
                time[cur.end]=cur.time;

                for(Edge next:edgeList.get(cur.end)){
                    if(cur.time+next.time<time[next.end]){
                        q.add(new Edge(next.end,cur.time+next.time));
                    }
                }
            }

            int ansTime = 0;
            int cnt = 0;

            for (int i = 1; i < n+1; i++) {
                if(time[i] != Integer.MAX_VALUE){
                    cnt++;
                    ansTime = Math.max(ansTime,time[i]);
                }
            }

            System.out.print(cnt+" "+ansTime);
            System.out.println();

        }
    }

    static class Edge{
        int end;
        int time;

        public Edge(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
}
