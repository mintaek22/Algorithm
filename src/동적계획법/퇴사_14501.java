package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        int maxScore = 0;
        StringTokenizer st;
        for(int i=1;i<N+1;i++){
            maxScore = Math.max(dp[i-1],maxScore);

            st=new StringTokenizer(br.readLine());
            int T=Integer.parseInt(st.nextToken());
            int P=Integer.parseInt(st.nextToken());

            int finishDay = T+i-1;
            if(finishDay<=N){
                dp[finishDay] = Math.max(maxScore + P,dp[finishDay]);
            }
        }

        System.out.println(Math.max(maxScore,dp[N]));
    }
}
