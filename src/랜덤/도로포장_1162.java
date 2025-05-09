package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도로포장_1162 {
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
            arr.get(start).add(new Edge(end,cost));
            arr.get(end).add(new Edge(start,cost));
        }

        long[][] distance = new long[N+1][K+1];

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(distance[i],Long.MAX_VALUE);
        };

        distance[1][0] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->Long.compare(a.cost, b.cost));
        q.add(new Node(1,0,0));

        while (!q.isEmpty()){
            Node cur = q.poll();

            if(cur.cost>distance[cur.end][cur.count]) continue;

            //다음 이동
            for(Edge next:arr.get(cur.end)){

                // 포장
                if(cur.count<K) {
                    if(distance[next.end][cur.count+1] > cur.cost){
                        distance[next.end][cur.count+1] = cur.cost;
                        q.add(new Node(next.end, cur.cost,cur.count+1));
                    }
                }

                // 비 포장
                if(distance[next.end][cur.count] > cur.cost+ next.cost){
                    distance[next.end][cur.count] = cur.cost + next.cost;
                    q.add(new Node(next.end, cur.cost+ next.cost,cur.count));
                }
            }
        }

        long ans = Long.MAX_VALUE;
        for(int i=0;i<K+1;i++){
            ans = Math.min(ans,distance[N][i]);
        }

        System.out.println(ans);
    }

    static class Edge{
        int end;
        long cost;

        public Edge(int end, long cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static class Node{
        int end;
        long cost;
        int count;

        public Node(int end, long cost, int count) {
            this.end = end;
            this.cost = cost;
            this.count = count;
        }
    }
}
