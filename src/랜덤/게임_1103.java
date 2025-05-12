package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 게임_1103 {

    static int N,M;
    static int[][] map;
    static int ans = 0;
    static boolean[][] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                if(c == 'H') map[i][j] = -1;
                else map[i][j] = Integer.parseInt(String.valueOf(c));
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true;

        dp = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
        dfs(0,0,0);

        System.out.println(ans);

    }

    static void dfs(int x,int y,int distance){
        //사이클 존재
        if(ans == -1) return;

        //구멍에 빠짐
        if(map[x][y] == -1){
            ans = Math.max(ans, distance);
            return;
        }

        //더 낮은 거리
        if(dp[x][y]>=distance) return;
        dp[x][y] = distance;

        int[] dx = new int[] {0,0,map[x][y],-map[x][y]};
        int[] dy = new int[] {map[x][y],-map[x][y],0,0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<M){
                //사이클 발생
                if(visited[nx][ny]){
                    ans = -1;
                    return;
                }

                visited[nx][ny] = true;
                dfs(nx,ny,distance+1);
                visited[nx][ny] = false;
            }
            //보드 나감
            else{
                if(ans!=-1) ans = Math.max(ans, distance+1);
            }
        }
    }
}
