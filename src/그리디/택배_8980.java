package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 택배_8980 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{
            if(o1.end== o2.end){
                return o1.start-o2.start;
            }
            return o1.end-o2.end;
        });

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            q.add(new Node(start,end,value));
        }

        int ans = 0;
        int[] weights = new int[N+1];
        Arrays.fill(weights,C);

        while(!q.isEmpty()){
            Node node = q.poll();
            int getValue = Math.min(node.value,C);
            for(int i=node.start+1;i<=node.end;i++){
                getValue = Math.min(getValue,weights[i]);
            }
            ans +=getValue;
            for(int i=node.start+1;i<=node.end;i++){
                weights[i] -= getValue;
            }
        }

        System.out.println(ans);
    }

    static class Node{
        int start;
        int end;
        int value;

        public Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
