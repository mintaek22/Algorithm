package 비트마스킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섞기_1176 {
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new long[(1 << N)][N];

        for(int i = 0; i < N; i++){
            dp[(1 << i)][i] = 1;
        }

        for (int depth = 1; depth < N; depth++) {
            for (int mask = 0; mask < (1 << N); mask++) {
                if (Integer.bitCount(mask) != depth) continue;

                for (int last = 0; last < N; last++) {
                    if (dp[mask][last] > 0) {
                        for (int next = 0; next < N; next++) {
                            if ((mask & (1 << next)) == 0 &&
                                    Math.abs(arr[last] - arr[next]) > K) {
                                dp[mask | (1 << next)][next] += dp[mask][last];
                            }
                        }
                    }
                }
            }
        }

        long ans = 0;
        for(int i = 0; i < N; i++){
            ans += dp[(1 << N) - 1][i];
        }
        System.out.println(ans);
    }
}