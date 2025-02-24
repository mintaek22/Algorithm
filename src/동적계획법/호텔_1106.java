package 동적계획법;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 호텔_1106 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            arr[i][0] = money;
            arr[i][1] = customer;
        }

        int[] dp = new int[C + 100];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            int cost = arr[i][0];
            int customer = arr[i][1];

            for (int j = customer; j < C+100; j++) {
                if (dp[j - customer] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - customer] + cost);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = C; i < C + 100; i++) {
            ans = Math.min(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
