package 다익스트라;

import java.io.*;
import java.util.*;

public class 최단경로구하기_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
        for (int i = 0; i <v+1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            arr.get(a).add(new Node(b,Integer.parseInt(st.nextToken())));
        }

        int[] distance = new int[v+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start] = 0;

        boolean[] visit = new boolean[v+1];
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.weight-o2.weight);
        q.add(new Node(start,0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            if(visit[now.end]) continue;
            visit[now.end] = true;
            for (Node node:arr.get(now.end)) {
                int weight = node.weight;
                if(distance[node.end]>distance[now.end]+weight){
                    distance[node.end] = distance[now.end]+weight;
                    q.add(new Node(node.end,distance[node.end]));
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < v+1; i++) {
            if(distance[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(distance[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static class Node{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
