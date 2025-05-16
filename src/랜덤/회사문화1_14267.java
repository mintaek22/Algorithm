package 랜덤;

import java.io.*;
import java.util.StringTokenizer;

public class 회사문화1_14267 {

    static int[] parent;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            dp[target] += value;
        }

        for (int i =2 ;i<N+1; i++) dp[i] += dp[parent[i]];

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i < N+1; i++) {
            bw.append(String.valueOf(dp[i])).append(" ");
        }

        bw.flush();

    }
}
