package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 곡예비행_21923 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+2][M+2];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] upDp = new int[N+2][M+2];
        for(int i=0;i<N+2;i++){
            Arrays.fill(upDp[i],-Integer.MAX_VALUE);
        }
        upDp[N][1] = map[N][1];
        for (int i = N; i >= 1; i--) {
            for (int j = 1; j <= M; j++) {
                if(i == N && j == 1) continue;
                upDp[i][j] = Math.max(upDp[i+1][j], upDp[i][j-1]) + map[i][j];
            }
        }

        int[][] downDp = new int[N+2][M+2];
        for(int i=0;i<N+2;i++){
            Arrays.fill(downDp[i],-Integer.MAX_VALUE);
        }
        downDp[N][M] = map[N][M];
        for (int i = N; i >= 1; i--) {
            for (int j = M; j >= 1; j--) {
                if(i == N && j == M) continue;
                downDp[i][j] = Math.max(downDp[i+1][j], downDp[i][j+1]) + map[i][j];
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                ans = Math.max(ans,upDp[i][j] + downDp[i][j]);
            }
        }

        System.out.println(ans);
    }
}
