package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 제곱수찾기_1025 {

    static long ans = -1;
    static int[][] map;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if(Math.sqrt(map[i][j]) % 1 == 0.0){
                    ans = Math.max(map[i][j],ans);
                }
                for (int x_gap = -N+1; x_gap < N; x_gap++) {
                    for (int y_gap = -M+1; y_gap <M; y_gap++) {
                        if(x_gap == 0 && y_gap == 0) continue;
                        int new_x = i + x_gap;
                        int new_y = j + y_gap;
                        if(new_x>=0 && new_x<N && new_y>=0 && new_y<M){
                            dfs(String.valueOf(map[i][j])+map[new_x][new_y],new_x,new_y,x_gap,y_gap);
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static void dfs(String str,int x,int y,int x_gap,int y_gap) {
        double num = Double.parseDouble(str);

        if(Math.sqrt(num) % 1 == 0.0){
            ans = Math.max((long)num,ans);
        }

        int new_x = x + x_gap;
        int new_y = y + y_gap;

        if(new_x>=0 && new_x<N && new_y>=0 && new_y<M){
            dfs(str+map[new_x][new_y],new_x,new_y,x_gap,y_gap);
        }

    }
}
