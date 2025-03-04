package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선발명단_3980 {

    static int[][] arr = new int[11][11];
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = 0;
            visited = new boolean[11];
            dfs(0, 0);
            System.out.println(ans);
        }
    }

    static void dfs(int sum,int position){
        if(position == 11){
            ans = Math.max(ans,sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if(arr[i][position] > 0 && !visited[i]){
                visited[i] = true;
                dfs(sum+arr[i][position], position+1);
                visited[i] = false;
            }
        }
    }
}
