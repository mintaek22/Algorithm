package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 함께블록쌓기_18427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] dp = new int[H+1];
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] saved = new int[H+1];
            for (int j = 0; j < M; j++) {
                if(st.hasMoreTokens()){
                    int height = Integer.parseInt(st.nextToken());
                    for(int k = H; k >= height; k--){
                        saved[k] = (saved[k] + dp[k-height]) % 10007;
                    }
                }
                else break;
            }
            for (int j = 1; j < H+1; j++) {
                dp[j] = (dp[j] + saved[j]) % 10007;
            }
        }

        System.out.println(dp[H]);
    }
}
