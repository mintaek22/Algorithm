package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 색상환_2482 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long ans = 0;

        //맨 앞을 색칠한 경우
        long[][][] dp = new long[N+1][K+1][2];
        dp[1][1][1] = 1;
        for (int i = 2; i < N+1; i++) {
            for (int j = 1; j < K+1; j++) {
                dp[i][j][1] = dp[i-1][j-1][0];
                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % 1000000003;
            }
        }

        ans += dp[N][K][0] % 1000000003;

        //맨앞을 안 칠한 경우
        dp = new long[N+1][K+1][2];
        dp[1][0][0] = 1;
        for (int i = 2; i < N+1; i++) {
            for (int j = 0; j < K+1; j++) {
                if(j>0) dp[i][j][1] = dp[i-1][j-1][0];
                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % 1000000003;
            }
        }

        ans += (dp[N][K][0] + dp[N][K][1])% 1000000003;
        ans %= 1000000003;

        System.out.println(ans);
    }
}
