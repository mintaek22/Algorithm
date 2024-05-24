package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 불우이웃돕기_1414 {

    private static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight-o2.weight);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char c= str.charAt(j);
                if(c =='0') continue;
                //소문자
                if((int)c >=97) {
                    if(i!=j) pq.add(new Edge(i,j,(int)(c) - 96));
                    sum += (int)(c) - 96;

                }
                else {
                    if(i!=j) pq.add(new Edge(i,j,(int)(c) - 38));
                    sum+= (int)(c) - 38;
                }
            }
        }



        map = new int[n];
        for (int i = 0; i < n ; i++) map[i] = i;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(find(edge.start) == find(edge.end)) continue;
            union(edge.start, edge.end);
            sum -= edge.weight;
        }

        int key = find(0);
        for (int i = 1; i < n; i++) {
            if(key != find(i)){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(sum);
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
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
