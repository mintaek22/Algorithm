package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 중량제한_1939 {


    static int N,M;
    static ArrayList<HashMap<Integer,Integer>> arr=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+1; i++) {
            arr.add(new HashMap<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.get(a).put(b,Math.max(arr.get(a).getOrDefault(b,0),c));
            arr.get(b).put(a,Math.max(arr.get(b).getOrDefault(a,0),c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)-> o2.min-o1.min);
        boolean[] visited = new boolean[N+1];
        int[] dp = new int[N+1];
        q.add(new Node(start,Integer.MAX_VALUE));

        while (!q.isEmpty()) {
            Node node = q.poll();
            if(visited[node.index]) continue;
            visited[node.index] = true;
            for(Integer child:arr.get(node.index).keySet()) {
                int weight = arr.get(node.index).get(child);
                int nextMin = Math.min(node.min,weight);
                if(nextMin > dp[child]) {
                    dp[child] = Math.min(node.min,weight);
                    q.add(new Node(child,nextMin));
                }
            }
        }
        System.out.println(dp[end]);
    }

    static class Node{
        int index;
        int min;

        public Node(int index, int min) {
            this.index = index;
            this.min = min;
        }
    }
}
