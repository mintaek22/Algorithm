package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 외판원순회_2098 {

    static int[][] map;
    static int[][] dp;
    static int N;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[1<<N][N];

        for (int i = 0; i < 1<<N ; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[1][0] = 0;

        dfs(1,0);

        for (int i = 1; i < N; i++) {
            if(map[i][0] == 0 || dp[(1<<N) - 1][i] == Integer.MAX_VALUE) continue;
            ans = Math.min(ans, dp[(1<<N) - 1][i] + map[i][0]);
        }

        System.out.println(ans);
    }

    static void dfs(int visited,int last){
        if (visited == (1 << N) - 1) return;
        for (int i = 0; i < N; i++) {
            //방문하지 않은 곳
            if((visited & (1 << i)) == 0){

                //못가는 길
                if(map[last][i] == 0) continue;

                //작으면
                if(dp[visited | (1<<i)][i] > dp[visited][last] + map[last][i]){
                    dp[visited | (1<<i)][i] = dp[visited][last] + map[last][i];
                    dfs(visited | (1<<i), i);
                }
            }
        }
    }



}
