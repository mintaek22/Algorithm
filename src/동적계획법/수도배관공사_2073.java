package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 수도배관공사_2073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[][] pipe = new int[P][2];

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pipe[i][0] = L;
            pipe[i][1] = C;
        }

        int[] dp = new int[D+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;

        for (int i=0;i< pipe.length;i++){
            int length = pipe[i][0];
            int value = pipe[i][1];
            for (int j = D; j >= length; j--) {
                if(dp[j-length]!= -1){
                    if(dp[j-length] == 0){
                        dp[j] = Math.max(dp[j],value);
                    }
                    else{
                        dp[j] = Math.max(dp[j],Math.min(dp[j-length],value));
                    }
                }
            }
        }

        System.out.println(dp[D]);
    }
}
