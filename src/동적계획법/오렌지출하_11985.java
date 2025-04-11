package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 오렌지출하_11985 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] orange = new int[N+1];
        for (int i = 1; i < N+1; i++) orange[i] = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];

        Arrays.fill(dp,Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < N+1; i++) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            for(int j=1;j<M+1;j++){
                if(i-j>=0){
                    min = Math.min(min,orange[i-j+1]);
                    max = Math.max(max,orange[i-j+1]);
                    dp[i] = Math.min(dp[i],dp[i-j]+K+(long)j*(max-min));
                }
            }
        }

        System.out.println(dp[N]);
    }
}
