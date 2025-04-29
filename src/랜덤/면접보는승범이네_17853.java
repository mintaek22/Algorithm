package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 면접보는승범이네_17853 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> arr = new ArrayList<>();
        for (int i = 0; i < N+1; i++) arr.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr.get(end).add(new Edge(start, cost));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>((a,b) -> Long.compare(a.cost,b.cost));
        st = new StringTokenizer(br.readLine());

        long[] distance = new long[N+1];
        Arrays.fill(distance, Long.MAX_VALUE);

        for (int i = 0; i < K; i++) {
            int start = Integer.parseInt(st.nextToken());
            q.add(new Edge(start, 0));
            distance[start] = 0;
        }

        while(!q.isEmpty()) {
            Edge e = q.poll();

            if(distance[e.end]<e.cost) continue;

            for(Edge next:arr.get(e.end)) {
                if(distance[next.end] > e.cost+next.cost) {
                    distance[next.end] = e.cost+next.cost;
                    q.add(new Edge(next.end, e.cost+next.cost));
                }
            }
        }

        long max = 0;
        int ans= 1;
        for(int i=1;i<N+1;i++){
            if(max<distance[i]) {
                max = distance[i];
                ans = i;
            }
        }
        System.out.println(ans);
        System.out.println(max);
    }

    static class Edge{
        int end;
        long cost;

        public Edge(int end, long cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
