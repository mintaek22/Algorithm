package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시분할계획_1647 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> q = new PriorityQueue<>((a,b)-> a.distance-b.distance);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            q.add(new Node(start, end, distance));
        }

        parent = new int[N + 1];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int ans = 0;
        int last = 0;

        while(!q.isEmpty()){
            Node node = q.poll();
            if(find(node.start) != find(node.end)){
                union(node.start, node.end);
                ans += node.distance;
                last = node.distance;
            }
        }

        ans -= last;

        System.out.println(ans);
    }

    static void union(int a,int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA != parentB) parent[parentA] = parentB;
    }

    static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    static class Node{
        int start;
        int end;
        int distance;

        public Node(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}
