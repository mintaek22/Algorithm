package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일루미네이션_5547 {

    static int[][] map;
    static boolean[][] visited;
    static int score = 0;
    static int[] even_dx = new int[] {-1,0,-1,1,-1,0};
    static int[] even_dy = new int[] {-1,-1,0,0,1,1};
    static int[] odd_dx = new int[] {0,1,-1,1,0,1};
    static int[] odd_dy = new int[] {-1,-1,0,0,1,1};
    static int W,H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[W+2][H+2];
        visited = new boolean[W+2][H+2];

        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(score);
    }

    static void dfs(int x,int y){
        visited[x][y] = true;
        for (int i = 0; i < 6; i++) {
            int new_x = x;
            int new_y = y;
            if(y%2 == 0){
                new_x += even_dx[i];
                new_y += even_dy[i];
            }
            else{
                new_x += odd_dx[i];
                new_y += odd_dy[i];
            }

            if(new_x>= 0 && new_x<=W+1 && new_y>=0 && new_y<=H+1 && !visited[new_x][new_y]){
                if(map[new_x][new_y]==1) score++;
                else dfs(new_x,new_y);
            }
        }
    }
}
