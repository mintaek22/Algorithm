package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 최소스패닝트리_1197 {

    static private int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<Edge> arr = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.add(new Edge(start, next, weight));
        }

        arr.sort((o1, o2) -> o1.weight - o2.weight);

        map = new int[v+1];
        for (int i = 0; i < v+1; i++) {
            map[i]=i;
        }

        int ans = 0;
        for (int i = 0; i < e; i++) {
            Edge edge = arr.get(i);
            //싸이클인지 확인
            if(find(edge.start) == find(edge.next)) continue;
            union(edge.start,edge.next);
            ans += edge.weight;
        }

        System.out.println(ans);

    }

    static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a!=b) map[a] = b;
    }

    static int find(int a){
        if(map[a] == a) return a;
        else return map[a] = find(map[a]);
    }

    static private class Edge{
        int start;
        int next;
        int weight;

        public Edge(int start, int next, int weight) {
            this.start = start;
            this.next = next;
            this.weight = weight;
        }
    }
}
