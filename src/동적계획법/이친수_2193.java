package 동적계획법;

import java.util.*;

//0으로 시작 X
//1이 두번 연속 x
public class 이친수_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n+1][2];
        dp[1][1] = 1;

        for(int i=2;i<n+1;i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[n][0]+dp[n][1]);
    }
}
