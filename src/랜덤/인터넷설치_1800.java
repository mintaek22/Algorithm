package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인터넷설치_1800 {
    /**
     * 최댓값 엣지를 최소로
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> edgeList = new ArrayList<>();
        for (int i = 0; i < N+1; i++) edgeList.add(new ArrayList<>());

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList.get(a).add(new Edge(b,c));
            edgeList.get(b).add(new Edge(a,c));
        }

        int[][] distance = new int[N+1][K+1];
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[1][0] = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1,0,0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for(Edge next: edgeList.get(cur.end)){
                if(distance[next.end][cur.kCount] > Math.max(cur.cost,next.cost)){
                    q.add(new Node(next.end, Math.max(cur.cost,next.cost), cur.kCount));
                    distance[next.end][cur.kCount] = Math.max(cur.cost,next.cost);
                }

                if(cur.kCount+1<=K && distance[next.end][cur.kCount+1] > cur.cost){
                    q.add(new Node(next.end, cur.cost, cur.kCount+1));
                    distance[next.end][cur.kCount+1] = cur.cost;
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<K+1;i++){
            ans = Math.min(ans,distance[N][i]);
        }

        if(ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    static class Node{
        int end;
        int cost;
        int kCount;

        public Node(int end, int cost, int kCount) {
            this.end = end;
            this.cost = cost;
            this.kCount = kCount;
        }
    }
    
    static class Edge{
        int end;
        int cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
