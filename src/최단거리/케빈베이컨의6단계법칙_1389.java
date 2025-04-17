package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙_1389 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                arr[i][j] = 10000;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    arr[j][k] = Math.min(arr[j][k],arr[j][i]+arr[i][k]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        int man = 0;

        for (int i = 1; i < n+1; i++) {
            int num = 0;
            for (int j = 1; j < n+1; j++) {
                num+= arr[i][j];
            }
            if(ans>num) man = i;
            ans = Math.min(ans,num);
        }

        System.out.println(man);

    }
}
