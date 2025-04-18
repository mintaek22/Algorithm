package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 공주님의정원_2457 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());

        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.start-b.start);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            q.add(new Node(transDate(startMonth,startDay),transDate(endMonth,endDay)));
        }

        int firstDay = transDate(3,1);
        int lastDay = transDate(11,30);

        int cnt = 0;
        int preLastDay = 0;
        int curLastDay = 0;

        //초기 값
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.start<=firstDay){
                cnt++;
                curLastDay = node.end;
                preLastDay = firstDay;
                break;
            }
        }

        while(!q.isEmpty()){
            Node node = q.poll();

            //교체
            if(preLastDay >= node.start && curLastDay < node.end){
                curLastDay = node.end;
            }
            //추가
            else if(curLastDay >= node.start && curLastDay < node.end){
                cnt++;
                preLastDay = curLastDay;
                curLastDay = node.end;
            }
            if(curLastDay > lastDay) break;
        }

        if(curLastDay<=lastDay) System.out.println(0);
        else System.out.println(cnt);
    }

    static int transDate(int month,int day){
        int[] preSum  = new int[] {0,31,28,31,30,31,40,31,31,30,31,30,31};
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] += preSum[i-1];
        }
        return preSum[month-1] + day;
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
