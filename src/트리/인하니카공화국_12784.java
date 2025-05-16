package 트리;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 인하니카공화국_12784 {
    /**
     * 다리가 하나인 섬에서 1번 섬에 접근하지 못하게
     * 다리가 하나인 섬은 리프 노드 밖에 없다
     * 자식 노드의 최소값의 합 vs 자신 노드의 연결 다리 중 작은거
     */

    static boolean[] visited;
    static ArrayList<ArrayList<Edge>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            visited = new boolean[N+1];
            tree = new ArrayList<>();
            for (int i = 0; i < N+1; i++) tree.add(new ArrayList<>());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                tree.get(start).add(new Edge(end, cost));
                tree.get(end).add(new Edge(start, cost));
            }

            visited[1] = true;
            bw.append(String.valueOf(find(1))).append("\n");
        }

        bw.flush();
    }

    static int find(int now){
        boolean isLeaf = true;

        //밑에 합하기
        int cost = 0;
        int parentCost = 0;

        for (Edge next : tree.get(now)) {
            if(!visited[next.end]){
                visited[next.end] = true;
                isLeaf = false;
                cost += find(next.end);
            }

            //방문한게 parent 위로 연결된 다리
            else parentCost = next.cost;
        }

        //루트
        if(now == 1) return cost;

        //리프
        if(isLeaf) return parentCost;

        //일반 노드
        return Math.min(cost, parentCost);
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
