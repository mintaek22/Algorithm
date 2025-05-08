package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 할일정하기1_1311 {

    static int[][] dp;
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int[][] dp = new int[N+1][1<<(N+1)];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i <= N; i++) {

            for (int j = 0; j < 1<<(N+1); j++) {
                if (dp[i-1][j] ==  Integer.MAX_VALUE) continue;

                for (int k = 1; k <= N; k++) {
                    if ((j&(1<<k)) != 0) continue;
                    dp[i][j|(1<<k)] = Math.min(dp[i][j|(1<<k)], dp[i-1][j] + arr[i][k]);
                }
            }

        }

        System.out.println(dp[N][(1<<(N+1))-2]);
    }

}
