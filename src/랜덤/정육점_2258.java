package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 정육점_2258 {
    /**
     * 지불 cost 보다 적은 것들은 value 덤
     * 최소 value에 대한 최소 cost
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->{
            if(a.cost == b.cost){
                return b.value-a.value;
            }
            return a.cost - b.cost;
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            q.add(new Node(value,cost));
        }

        long ans = Long.MAX_VALUE;
        long sum  = 0;
        long beforeCost = -1;
        int temp = 0;
        long cnt = 0;

        while(!q.isEmpty()){
            Node node = q.poll();

            //이전 cost와 같은 경우
            if(node.cost == beforeCost){
                cnt++;
                temp += node.value;
                if(sum + temp >=M && ans > node.cost*cnt){
                    ans = node.cost*cnt;
                }

            }
            else{
                sum += temp;
                beforeCost = node.cost;
                temp = node.value;
                cnt = 1;

                if(sum + temp >=M && ans>node.cost){
                    ans = node.cost;
                }
            }

        }

        if(ans == Long.MAX_VALUE) ans = -1;
        System.out.println(ans);


    }

    static class Node{
        int value;
        int cost;

        public Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }
    }


}
