package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기2_11779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
        for (int i = 0; i < N+1; i++) arr.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];
        int[] parent = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.cost- b.cost);
        q.add(new Node(start, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if(visited[cur.end]) continue;
            visited[cur.end] = true;
            for(Node next: arr.get(cur.end)) {
                int new_cost = cur.cost + next.cost;
                if(distance[next.end] > new_cost) {
                    distance[next.end] = new_cost;
                    parent[next.end] = cur.end;
                    q.add(new Node(next.end, new_cost));
                }
            }
        }

        ArrayList<Integer> ans  = new ArrayList<>();
        ans.add(end);

        int now = end;
        while(parent[now] != start){
            ans.add(0,parent[now]);
            now = parent[now];
        }
        ans.add(0,start);

        System.out.println(distance[end]);
        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }

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
