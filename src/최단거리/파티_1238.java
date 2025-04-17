package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티_1238 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> arr = new ArrayList<>();

        for (int i = 0; i < N+1; i++) arr.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end, cost));
        }

        int[] go = new int[N+1];
        int[] back = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            int[] distance = new int[N+1];
            boolean[] visited = new boolean[N+1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[i] = 0;

            PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.cost-b.cost);
            q.add(new Node(i, 0));
            while (!q.isEmpty()) {
                Node cur = q.poll();
                if(visited[cur.end]) continue;
                visited[cur.end] = true;
                for (Node next:arr.get(cur.end)) {
                    int new_cost = cur.cost +next.cost;
                    if(distance[next.end] > new_cost) {
                        distance[next.end] = new_cost;
                        q.add(new Node(next.end, new_cost));
                    }

                }
            }

            if(i == X) back = distance.clone();
            go[i] = distance[X];
        }

        int ans = 0;


        for (int i =1; i < N+1; i++) {
            ans = Math.max(ans, go[i]+back[i]);
        }

        System.out.println(ans);

    }

    static class Node{
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}