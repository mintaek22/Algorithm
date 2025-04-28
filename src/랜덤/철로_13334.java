package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 철로_13334 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.end - b.end);

        for (int i = 0; i < N; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            q.add(new Node(Math.min(h,o),Math.max(h,o)));
        }

        int D = Integer.parseInt(br.readLine());

        int ans = 0;

        PriorityQueue<Node> startQ = new PriorityQueue<>((a,b)->a.start - b.start);
        while(!q.isEmpty()){
            Node node = q.poll();
            int lineLast = node.end;
            int lineStart = lineLast-D;

            while(!startQ.isEmpty() && startQ.peek().start < lineStart) startQ.poll();

            if(node.start>=lineStart) startQ.add(node);

            ans = Math.max(ans,startQ.size());
        }

        System.out.println(ans);
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
