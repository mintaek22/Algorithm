package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전바꿔주기_2642 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] coinList = new int[k+1][2];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            coinList[i][0] = value;
            coinList[i][1] = count;
        }

        int[] dp = new int[T + 1];
        dp[0] = 1;

        for (int[] coin : coinList) {
            int value = coin[0];
            int count = coin[1];
            for (int j = T; j >= value; j--) {
                for(int c= 1;c<=count;c++){
                    if(j-value*c>=0) dp[j] += dp[j - value*c];
                }
            }
        }

        System.out.println(dp[T]);
    }
}
