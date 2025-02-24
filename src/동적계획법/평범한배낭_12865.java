package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[100001][N+1];

        int ans = 0;

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            for (int j = 1; j < weight; j++) {
                dp[j][i] = dp[j][i-1];
            }
            for (int j = weight; j < K+1; j++) {
                dp[j][i] = Math.max(dp[j][i-1], dp[j-weight][i-1]+value);
                ans = Math.max(ans,dp[j][i]);
            }
        }



        System.out.println(ans);
    }
}
