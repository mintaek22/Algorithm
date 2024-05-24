package 플로이드워셜;

import java.io.*;
import java.util.StringTokenizer;

public class 플로이드_11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] distance = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(i == j) distance[i][j] = 0;
                else distance[i][j] = 10000001;
            }
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(distance[a][b]>c)distance[a][b] = c;
        }



        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                for (int k = 1; k < n+1; k++) {
                    distance[j][k] = Math.min(distance[j][k],distance[j][i]+distance[i][k]);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(distance[i][j] == 10000001) bw.write("0 ");
                else bw.write(distance[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
