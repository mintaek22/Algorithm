package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 짝수팰린드롬_21925 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) arr[i] = Integer.parseInt(st.nextToken());


        boolean[][] isPossible = new boolean[N+1][N+1];

        for (int i = 2; i < N+1; i++) {
            int start = i-1;
            int end = i;
            while(start>0 && end<N+1  && arr[start] == arr[end]){
                isPossible[start][end] = true;
                start--;
                end++;
            }
        }

        int[] dp = new int[N+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;

        for (int i = 2; i < N+1; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] != -1){
                    if(isPossible[j+1][i]){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
            }
        }

        System.out.println(dp[N]);
    }
}
