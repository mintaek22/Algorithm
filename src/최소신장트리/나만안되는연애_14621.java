package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나만안되는연애_14621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] isMan = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            if(st.nextToken().equals("M")) isMan[i] = true;
        }

        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
        for (int i = 0; i < N+1; i++) arr.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end, cost));
            arr.get(end).add(new Node(start, cost));
        }

        for (int i = 0; i < N+1; i++) arr.get(i).sort((a,b)->a.cost- b.cost);


        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.cost-b.cost);
        q.add(new Node(1, 0));

        boolean[] visited = new boolean[N+1];
        int ans = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if(visited[cur.end]) continue;
            ans += cur.cost;
            visited[cur.end] = true;
            for(Node next: arr.get(cur.end)) {
                if(!visited[next.end]){
                    if((isMan[cur.end] && !isMan[next.end]) || (!isMan[cur.end] && isMan[next.end])){
                        q.add(new Node(next.end, next.cost));
                    }
                }
            }
        }

        for (int i = 1; i < N+1; i++) {
            if(!visited[i]){
                System.out.println(-1);
                return;
            };
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
