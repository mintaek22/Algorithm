package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 두 수를 묶기(곱하기)
 * 한번만 묶기
 * 최댓값
 * 양수는 큰수끼리 묶기
 * 음수는 음수 큰수끼리 묶기
 * 음수 남으면 0이랑 묶기
 */
public class 수묶기_1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //묶음 개수
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> mq = new PriorityQueue<>();
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            int num =Integer.parseInt(br.readLine());
            if(num>1){
                pq.add(num);
            }
            else if(num == 1){
                one++;
            }
            else if(num == 0){
                zero++;
            }
            else{
                mq.add(num);
            }
        }

        int ans = one;

        while (pq.size()>=2){
            ans += pq.poll()*pq.poll();
        }

        if (!pq.isEmpty()) {
            ans += pq.poll();
        }

        while (mq.size()>=2){
            ans += mq.poll()*mq.poll();
        }

        if (!mq.isEmpty()) {
            if(zero == 0){
                ans += mq.poll();
            }
        }

        System.out.println(ans);
    }
}
