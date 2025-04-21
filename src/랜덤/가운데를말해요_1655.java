package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 가운데를말해요_1655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());

        //오름차순,내림차순
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a,b)->b-a);

        //초기
        int mid = Integer.parseInt(br.readLine());
        System.out.println(mid);

        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num>=mid) minQ.add(num);
            else maxQ.add(num);

            // 홀수일땐 사이즈가 같으면 중앙값
            // 짝수면 위에 개수가 하나더 많으면 중앙값
            if((minQ.size() == maxQ.size()) || (maxQ.size()==minQ.size()-1)){}
            //위에 값이 2개 더 많으면
            else if(maxQ.size()==minQ.size()-2){
                maxQ.add(mid);
                mid = minQ.poll();
            }
            //아래 값이 하나더 많으면
            else if(maxQ.size()-1==minQ.size()){
                minQ.add(mid);
                mid = maxQ.poll();
            }

            System.out.println(mid);
        }

    }
}
