package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 줄세우기_2631 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(N-result);
    }
}
