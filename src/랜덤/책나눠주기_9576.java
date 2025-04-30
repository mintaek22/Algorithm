package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 책나눠주기_9576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            PriorityQueue<Node> q = new PriorityQueue<>((a,b)-> {
                if(a.end == b.end){
                    return a.start-b.start;
                }
                return a.end - b.end;
            });

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                q.add(new Node(a,b));
            }

            boolean[] visited =new boolean[N+1];

            int ans = 0;

            while(!q.isEmpty()){
                Node cur = q.poll();
                for (int i = cur.start; i <= cur.end; i++) {
                    if (!visited[i]) {
                        visited[i] = true;
                        ans++;
                        break;
                    }
                }
            }

            System.out.println(ans);
        }
    }

    static class Node{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
