package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 환승_5214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < N+M+1; i++) arr.add(new ArrayList<>());

        for (int i = N+1; i < M+N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr.get(i).add(num);
                arr.get(num).add(i);
            }
        }

        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.cnt - b.cnt);
        boolean[] visited = new boolean[N+M+1];
        visited[1] = true;
        q.add(new Node(1,1));

        int ans = -1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if(node.num == N){
                ans = node.cnt;
                break;
            }

            for (int next : arr.get(node.num)) {
                //하이퍼 루프
                if(!visited[next]){
                    visited[next] = true;
                    if(next>N){
                        q.add(new Node(next,node.cnt));
                    }
                    else{
                        q.add(new Node(next,node.cnt +1));
                    }
                }
            }
        }
        System.out.println(ans);

    }

    static class Node{
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

}
