package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간자르기_2283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] preSum = new long[1000001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            preSum[start+1] += 1;
            if(end != 1000000) preSum[end+1] -= 1;
        }

        for (int i = 1; i < 1000001; i++) {
            preSum[i] += preSum[i-1];
        }
        for (int i = 1; i < 1000001; i++) {
            preSum[i] += preSum[i-1];
        }

        int start = 0;
        int end = 0;

        boolean isAnswer = false;

        while(end<1000001 &&  start<=end){
            long sum = preSum[end]-preSum[start];

            if(sum==K) {
                isAnswer = true;
                break;
            }
            else if(sum<K) end++;
            else start++;
        }

        if(isAnswer) System.out.println(start+" "+end);
        else System.out.println("0 0");
    }
}
