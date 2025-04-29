package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 계단수_1562 {

    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new long[1<<10][N+1][10];
        for(int i=1;i<=9;i++){
            dp[1<<i][1][i] = 1;
        }

        //길이를 늘려가며
        for(int i=1;i<N;i++){
            //방문한 곳
            for(int j=0;j<(1<<10);j++){
                //마지막 수
                for(int k=0;k<=9;k++){

                    //마지막 수 하나 올리기
                    if(k+1<=9){
                        dp[j | 1<<(k+1)][i+1][k+1] += dp[j][i][k];
                        dp[j | 1<<(k+1)][i+1][k+1] %= 1000000000;
                    }

                    //마지막 수 하나 내리기
                    if(k-1>=0){
                        dp[j | 1<<(k-1)][i+1][k-1] += dp[j][i][k];
                        dp[j | 1<<(k-1)][i+1][k-1] %= 1000000000;
                    }
                }
            }
        }


        long ans = 0;
        for(int i=0;i<=9;i++){
            ans += dp[(1<<10) -1][N][i];
            ans %= 1000000000;
        }

        System.out.println(ans);
    }


}
