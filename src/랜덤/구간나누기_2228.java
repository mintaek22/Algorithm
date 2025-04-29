package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구간나누기_2228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] preSum = new int[N+1];
        for (int i = 1; i < N+1; i++) arr[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i < N+1; i++) preSum[i] = preSum[i-1] +  arr[i];

        //구간 개수,포함
        int[][] dp = new int[M+1][N+1];

        for (int i = 0; i < M+1; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        //구간 1개 일때
        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < i; j++) {
                dp[1][i] = Math.max(dp[1][i], preSum[i] - preSum[j]);
            }
        }


        //개수
        for(int i=1;i<M;i++){
            //포함
            for(int j=1;j<N+1;j++){
                if(dp[i][j] == Integer.MIN_VALUE) continue;
                //다음 구간 시작
                for(int k=j+1;k<N+1;k++){
                    //다음 구간 끝
                    for (int l = k+1; l < N+1; l++) {
                        dp[i+1][l] = Math.max(dp[i+1][l], dp[i][j] + preSum[l]-preSum[k]);
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N+1; i++) {
            ans = Math.max(ans, dp[M][i]);
        }
        System.out.println(ans);
    }
}
