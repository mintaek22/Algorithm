package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 컵라면_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)-> b.deadLine- a.deadLine);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            q.add(new Node(day,value));
        }
        int date = q.peek().deadLine;

        int ans = 0;

        PriorityQueue<Node> possibleNode = new PriorityQueue<>((a,b)-> b.value-a.value);
        while(date >=1) {
            while(!q.isEmpty()){
                Node node = q.peek();
                if(node.deadLine>= date){
                    possibleNode.add(q.poll());
                }
                else break;
            }
            if(!possibleNode.isEmpty()) ans += possibleNode.poll().value;
            date--;
        }
        System.out.println(ans);
    }

    static class Node{
        int deadLine;
        int value;

        public Node(int deadLine, int value) {
            this.deadLine = deadLine;
            this.value = value;
        }
    }
}
