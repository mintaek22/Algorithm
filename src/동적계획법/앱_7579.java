package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 앱_7579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] memories = new int[N];
        for (int i = 0; i < N; i++) memories[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cost = new int[N];
        for (int i = 0; i < N; i++) cost[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[10001];


        for (int i = 0; i < N; i++) {
            int curMemory = memories[i];
            int curCost = cost[i];
            for (int j = dp.length-1; j >= 0; j--) {
                if(j>=curCost){
                    dp[j] = Math.max(dp[j],dp[j-curCost]+curMemory);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i]>=M) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}
