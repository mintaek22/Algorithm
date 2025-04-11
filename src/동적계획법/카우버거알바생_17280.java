package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카우버거알바생_17280 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[M+1][K+1];

        int[][] order = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int burger = Integer.parseInt(st.nextToken());
            int potato = Integer.parseInt(st.nextToken());
            order[i][0] = burger;
            order[i][1] = potato;
        }

        for (int i = 0; i < N; i++) {
            int burger = order[i][0];
            int potato = order[i][1];
            for (int j = M; j >= 0; j--) {
                for (int k = K; k >=0; k--) {
                    if (j >= burger && k >= potato) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - burger][k - potato] + 1);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < M+1; i++) {
            for (int j = 1; j < K+1; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }
}
