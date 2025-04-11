package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 마라톤2_10653 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }

        int[][] dp = new int[N][K+1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < K+1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < K+1; j++) {
                for (int k=0;k<=j;k++){
                    if(i>=k+1) {
                        dp[i][j] = Math.min(dp[i][j],dp[i-k-1][j-k]+Math.abs(arr[i-k-1][0]-arr[i][0])+Math.abs(arr[i-k-1][1]-arr[i][1]));
                    }
                }
            }
        }


        int ans = Integer.MAX_VALUE;
        for(int i=0;i<K+1;i++){
            ans = Math.min(ans,dp[N-1][i]);
        }

        System.out.println(ans);
    }
}
