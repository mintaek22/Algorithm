package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int score = 0;
        int ans = Integer.MAX_VALUE;
        while(start<=end && end<=N) {
            if (S <= score) {
                ans = Math.min(ans, end-start);
                score -= arr[start];
                start++;
            }
            else{
                score += arr[end];
                end++;
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);

    }
}
