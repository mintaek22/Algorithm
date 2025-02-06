package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일로만들기_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        dp[1] = 0;
        for (int i = 2; i < N+1; i++) {
            if(i%3 == 0){
                dp[i] = Math.min(dp[i/3] + 1,dp[i]);
            }
            if(i%2 == 0){
                dp[i] = Math.min(dp[i/2] + 1,dp[i]);
            }

            dp[i] = Math.min(dp[i - 1] + 1,dp[i]);
        }

        System.out.println(dp[N]);
    }
}
