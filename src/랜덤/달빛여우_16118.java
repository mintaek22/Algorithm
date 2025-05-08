package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 달빛여우_16118 {
    /**
     * 여우 일정한 속도(최단거리)
     * 늑대 2배,0.5배 (홀수 일때 빠르게 접근)
     * 양방향
     * 1번시작
     * 여우가 더 빠를 수 있도록
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> arr = new ArrayList<>();
        for (int i = 0; i < N+1; i++) arr.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            //짝수 만들기
            arr.get(start).add(new Edge(end,d*2));
            arr.get(end).add(new Edge(start,d*2));
        }

        int[] distanceFox = new int[N+1];
        Arrays.fill(distanceFox, Integer.MAX_VALUE);
        distanceFox[1] = 0;

        PriorityQueue<Edge> q = new PriorityQueue<>((a,b)->a.cost-b.cost);
        q.add(new Edge(1,0));

        while (!q.isEmpty()) {
            Edge edge = q.poll();

            if(edge.cost>distanceFox[edge.end]) continue;

            for (Edge next: arr.get(edge.end)) {
                int new_cost = edge.cost+next.cost;
                if(distanceFox[next.end]>new_cost) {
                    distanceFox[next.end] = new_cost;
                    q.add(new Edge(next.end,new_cost));
                }
            }
        }

        int[] distanceWolfFast = new int[N+1];
        int[] distanceWolfSlow = new int[N+1];
        Arrays.fill(distanceWolfFast, Integer.MAX_VALUE);
        Arrays.fill(distanceWolfSlow, Integer.MAX_VALUE);
        distanceWolfSlow[1] = 0;

        PriorityQueue<Node> wolfQ = new PriorityQueue<>((a,b)->a.cost-b.cost);
        wolfQ.add(new Node(1,0,false));

        while (!wolfQ.isEmpty()) {
            Node node = wolfQ.poll();

            if(node.isFast && node.cost>distanceWolfFast[node.end]) continue;
            if(!node.isFast && node.cost>distanceWolfSlow[node.end]) continue;

            for (Edge next: arr.get(node.end)) {
                int new_cost = node.cost;

                //다음은 느리게
                if(node.isFast) new_cost += next.cost * 2;
                else new_cost += next.cost / 2;

                if(node.isFast &&  distanceWolfSlow[next.end]>new_cost) {
                    distanceWolfSlow[next.end] = new_cost;
                    wolfQ.add(new Node(next.end,new_cost,false));
                }

                if(!node.isFast &&  distanceWolfFast[next.end]>new_cost) {
                    distanceWolfFast[next.end] = new_cost;
                    wolfQ.add(new Node(next.end,new_cost,true));
                }
            }
        }

        int ans = 0;

        for(int i=1;i<N+1;i++){
            if(distanceFox[i] < Math.min(distanceWolfFast[i],distanceWolfSlow[i])) ans++;
        }

        System.out.println(ans);

    }

    static class Edge{
        int end;
        int cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static class Node{
        int end;
        int cost;
        boolean isFast;

        public Node(int end, int cost, boolean isFast) {
            this.end = end;
            this.cost = cost;
            this.isFast = isFast;
        }
    }
}
