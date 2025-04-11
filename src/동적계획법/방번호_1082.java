package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 방번호_1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cost = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        String[] dp = new String[M + 1];
        Arrays.fill(dp, null);
        dp[0] = "";

        for (int i = 0; i <= M; i++) {
            if (dp[i] == null) continue;

            for (int d = 0; d < N; d++) {
                int c = cost[d];
                if (i + c > M) continue;

                String candidate = dp[i] + d;

                if (candidate.charAt(0) == '0') continue;

                String existing = dp[i + c];
                if (existing == null || compare(candidate, existing) > 0) {
                    dp[i + c] = candidate;
                }
            }
        }

        String ans = "0";
        for (int i = 1; i <= M; i++) {
            if (dp[i] != null && compare(dp[i], ans) > 0) {
                ans = dp[i];
            }
        }

        System.out.println(ans);
    }

    private static int compare(String a, String b) {
        if (a.length() != b.length()) return Integer.compare(a.length(), b.length());
        return a.compareTo(b);
    }
}