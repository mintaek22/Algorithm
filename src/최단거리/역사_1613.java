package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 역사_1613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start][end] = -1;
            map[end][start] = 1;
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                for (int k = 1; k < N+1; k++) {
                    if(map[j][i] == 0 || map[i][k] == 0) continue;
                    else if(map[j][i] == 1 && map[i][k] == 1) map[j][k] = 1;
                    else if(map[j][i] == -1 && map[i][k] == -1) map[j][k] = -1;
                }
            }
        }

        int S = Integer.parseInt(br.readLine());
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(map[start][end]);
        }
    }
}
