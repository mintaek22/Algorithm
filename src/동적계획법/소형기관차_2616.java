package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소형기관차_2616 {

    static int[] preSum;
    static int[][] dp;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());

        preSum = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) preSum[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N+1; i++) preSum[i] += preSum[i-1];

        M = Integer.parseInt(br.readLine());

        dp = new int[N+1][4];
        for(int i=M;i<N+1;i++){
            dp[i][1] = Math.max(preSum[i] - preSum[i-M],dp[i-1][1]);
        }

        for(int i=2*M;i<N+1;i++){
            dp[i][2] = Math.max(dp[i-M][1]+preSum[i] - preSum[i-M],dp[i-1][2]);
        }

        int ans = 0;

        for(int i=3*M;i<N+1;i++){
            dp[i][3] = Math.max(dp[i-M][2]+preSum[i] - preSum[i-M],dp[i-1][3]);
            ans = Math.max(ans,dp[i][3]);
        }

        System.out.println(ans);

    }
}
