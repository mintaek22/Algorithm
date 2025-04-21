package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파일합치기_11066 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            int[] prefixSum = new int[N + 1];
            int[][] dp = new int[N + 1][N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                prefixSum[i] = prefixSum[i - 1] + arr[i];
            }

            for (int len = 2; len <= N; len++) {
                for (int i = 1; i + len - 1 <= N; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j],
                                dp[i][k] + dp[k + 1][j] + prefixSum[j] - prefixSum[i - 1]);
                    }
                }
            }

            System.out.println(dp[1][N]);
        }
    }
}