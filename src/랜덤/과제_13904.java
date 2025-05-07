package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 과제_13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.day-b.day);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            q.add(new Node(d,w));
        }

        PriorityQueue<Integer> ans = new PriorityQueue<>();
        while(!q.isEmpty()){
            Node node = q.poll();
            //공간이 있다
            if(ans.size()<node.day){
                ans.add(node.value);
            }
            else{
                //가장 아래 value 보다 크다
                if(!ans.isEmpty() && ans.peek()< node.value){
                    ans.poll();
                    ans.add(node.value);
                }
            }
        }

        int answer = 0;
        while(!ans.isEmpty()) answer += ans.poll();

        System.out.println(answer);
    }

    static class Node{
        int day;
        int value;

        public Node(int day, int value) {
            this.day = day;
            this.value = value;
        }
    }

}
