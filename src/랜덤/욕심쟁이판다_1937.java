package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 욕심쟁이판다_1937 {

    static int[] dx = new int[] {1,-1,0,0};
    static int[] dy = new int[] {0,0,1,-1};
    static int[][] dp;
    static int[][] map;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }

        System.out.println(ans);
    }

    static int dfs(int x,int y){
        if(dp[x][y]!=0) return dp[x][y];

        dp[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<N){
                //갈 수 있으면
                if(map[x][y]<map[nx][ny]){
                    dp[x][y] = Math.max(dp[x][y],dfs(nx,ny)+1);
                }
            }
        }

        return dp[x][y];
    }


}
