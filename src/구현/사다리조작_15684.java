package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리조작_15684 {

    static int N,M,H;
    static int ans=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[a][b + 1] = 2;
        }

        dfs(map,0);

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }

    static void dfs(int[][] map,int depth){

        if(depth == ans) return;

        if(check(map)) {
            ans = Math.min(depth,ans);
            return;
        }

        if(depth>=3) return;

        for (int i = 1; i < H+1; i++) {
            for (int j = 1; j < N; j++) {
                //사다리 두기
                if(map[i][j] == 0 && map[i][j+1] == 0){
                    map[i][j] = 1;
                    map[i][j+1] = 2;
                    dfs(map,depth+1);
                    map[i][j] = 0;
                    map[i][j+1] = 0;
                }
            }
        }
    }

    static boolean check(int[][] map){
        for (int i = 1; i < N+1; i++) {
            int x = 1;
            int y = i;
            while(x <= H){
                if(map[x][y] == 1) y++;
                else if(map[x][y] == 2) y--;
                x++;
            }
            if(y != i) return false;
        }
        return true;
    }
}
