package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 그림교환_1029 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N]; // 0-based index로 변경

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] dp = new int[1 << N][N];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        dp[1 << 0][0] = 0;

        int max = 1;

        for (int bit = 0; bit < (1 << N); bit++) {
            for (int last = 0; last < N; last++) {
                if (dp[bit][last] == Integer.MAX_VALUE) continue;

                for (int next = 0; next < N; next++) {
                    if ((bit & (1 << next)) == 0 && map[last][next] >= dp[bit][last]) {
                        int nextBit = bit | (1 << next);
                        dp[nextBit][next] = Math.min(dp[nextBit][next], map[last][next]);
                        max = Math.max(max, Integer.bitCount(nextBit));
                    }
                }
            }
        }

        System.out.println(max);
    }
}