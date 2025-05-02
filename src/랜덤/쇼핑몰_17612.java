package 랜덤;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 쇼핑몰_17612 {
    /**
     * 기다리는 시간이 같으면 적은 숫자
     * 높은 계산대 부터 빠짐
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> outList = new PriorityQueue<>((a,b)->{
            if(a.time == b.time){
                return b.casherId -a.casherId;
            }
            return a.time-b.time;
        });

        PriorityQueue<Node> casherList = new PriorityQueue<>((a,b)->{
            if(a.time == b.time){
                return a.casherId -b.casherId;
            }
            return a.time-b.time;
        });

        for (int i = 0; i < K; i++) {
            //처음에는 고객이 없으므로 회원 아이디 -1
            casherList.add(new Node(i,-1,0));
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            //가장 빠른 캐셔
            if(!casherList.isEmpty()){
                Node chaser = casherList.poll();

                //이전 고객이 있다.
                if(chaser.id != -1) outList.add(new Node(chaser.casherId,chaser.id,chaser.time));
                casherList.add(new Node(chaser.casherId,id, chaser.time+time));
            }
        }

        while(!casherList.isEmpty()){
            Node chaser = casherList.poll();
            if(chaser.id != -1) outList.add(new Node(chaser.casherId,chaser.id,chaser.time));
        }

        long answer = 0;

        int order = 1;
        while(!outList.isEmpty()){
            Node out = outList.poll();
            answer += (long)out.id * order;
            order++;
        }

        System.out.println(answer);
    }


    static class Node{
        int casherId;
        int id;
        int time;

        public Node(int casherId, int id, int time) {
            this.casherId = casherId;
            this.id = id;
            this.time = time;
        }
    }

}
