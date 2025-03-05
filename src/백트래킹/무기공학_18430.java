package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무기공학_18430 {
    
    static int[][] arr;
    static int N,M;
    static boolean[][] visited;
    static int[][] dx = new int[][] {{0,-1},{-1,0},{0,1},{1,0}};
    static int[][] dy = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(ans);
    }

    static void dfs(int index,int sum){
        if(index == N*M){
            ans = Math.max(ans,sum);
            return;
        }

        int x = index/M;
        int y = index%M;

        if(!visited[x][y]){
            for (int i = 0; i<4 ; i++) {
                int new_x = x+dx[i][0];
                int new_y = y+dy[i][0];
                int new_x2 = x+dx[i][1];
                int new_y2 = y+dy[i][1];
                if(new_x>=0 && new_x2>=0 && new_x<N && new_x2<N  && new_y>=0 && new_y2>=0 && new_y<M && new_y2<M){
                    if(!visited[new_x][new_y] && !visited[new_x2][new_y2] && !visited[x][y]){
                        visited[new_x][new_y] = true;
                        visited[new_x2][new_y2] = true;
                        visited[x][y] = true;
                        dfs(index+1,sum + arr[new_x][new_y] + arr[new_x2][new_y2] + 2*arr[x][y]);
                        visited[new_x][new_y] = false;
                        visited[new_x2][new_y2] = false;
                        visited[x][y] = false;
                    }
                }
            }
        }
        dfs(index+1,sum);
    }
}
