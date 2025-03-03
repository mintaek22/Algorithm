package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이조각_14391 {

    static int N,M,ans = 0;
    static String[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }
        visited = new boolean[N][M];
        dfs(0);
        System.out.println(ans);

    }

    static void dfs(int index){
        if(index == N*M){
            calculation();
            return;
        }
        visited[index/M][index%M] = true;
        dfs(index+1);
        visited[index/M][index%M] = false;
        dfs(index+1);

    }

    static void calculation(){
        int sum = 0;
        for (int i = 0; i < N; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) tmp.append(map[i][j]);
                else{
                    if(tmp.length()>0){
                        sum += Integer.parseInt(tmp.toString());
                        tmp = new StringBuilder();
                    }
                }
            }
            if(tmp.length()>0) sum += Integer.parseInt(tmp.toString());
        }

        for (int i = 0; i < M; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if(!visited[j][i]) tmp.append(map[j][i]);
                else{
                    if(tmp.length()>0){
                        sum += Integer.parseInt(tmp.toString());
                        tmp = new StringBuilder();
                    }
                }
            }
            if(tmp.length()>0) sum += Integer.parseInt(tmp.toString());
        }

        ans = Math.max(ans, sum);
    }
}
