package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 카드구매하기_11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //사야될 개수
        int n = Integer.parseInt(br.readLine());
        String[] s_arr = br.readLine().split(" ");
        int[] arr = new int[s_arr.length+1];
        for(int i=1;i<s_arr.length+1;i++){
            arr[i] = Integer.parseInt(s_arr[i-1]);
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i],dp[i-j]+arr[j]);
            }
        }

        System.out.println(dp[n]);

    }
}
