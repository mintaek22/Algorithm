package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점수따먹기_1749 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < N+1; i++) arr[i][1] += arr[i-1][1];
        for(int i = 1; i < M+1; i++) arr[1][i] += arr[1][i-1];

        for (int i = 2; i < N+1; i++) {
            for (int j = 2; j < M+1; j++) {
                arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < M+1; j++) {
                for (int k = 0; k < i; k++) {
                    for (int l = 0; l < j; l++) {
                        ans = Math.max(ans, arr[i][j] - arr[k][j] - arr[i][l] + arr[k][l]);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
