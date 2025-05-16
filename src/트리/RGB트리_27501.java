package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RGB트리_27501 {

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[][] score;
    static boolean[] visited;
    static int[][] dp;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N+1; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree.get(start).add(end);
            tree.get(end).add(start);
        }

        score = new int[N+1][3];

        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());
            score[i][0] = red;
            score[i][1] = green;
            score[i][2] = blue;
        }

        visited = new boolean[N+1];
        visited[1] = true;
        dp = new int[N+1][3];

        dfs(1);

        ans = new int[N+1];
        visited = new boolean[N+1];
        visited[1] = true;

        int startColor;
        if(dp[1][0] >= dp[1][1] && dp[1][0] >= dp[1][2]) startColor = 0;
        else if(dp[1][1] >= dp[1][0] && dp[1][1] >= dp[1][2]) startColor = 1;
        else startColor = 2;

        ans[1] = startColor;
        for(int next:tree.get(1)){
            visited[next] = true;
            tracking(next,startColor);
        }

        System.out.println(dp[1][startColor]);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+1; i++) {
            int color = ans[i];
            if(color == 0) sb.append('R');
            else if(color == 1) sb.append('G');
            else sb.append('B');
        }
        System.out.println(sb);
    }

    static void dfs(int num){

        dp[num][0] = score[num][0];
        dp[num][1] = score[num][1];
        dp[num][2] = score[num][2];

        for (int next : tree.get(num)) {
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
                dp[num][0] += Math.max(dp[next][1],dp[next][2]);
                dp[num][1] += Math.max(dp[next][0],dp[next][2]);
                dp[num][2] += Math.max(dp[next][0],dp[next][1]);
            }
        }
    }

    static void tracking(int num,int pre){
        if(pre == 0){
            if(dp[num][1] >= dp[num][2]) ans[num] = 1;
            else ans[num] = 2;
        }
        else if(pre == 1){
            if(dp[num][0] >= dp[num][2]) ans[num] = 0;
            else ans[num] = 2;
        }
        else{
            if(dp[num][0] >= dp[num][1]) ans[num] = 0;
            else ans[num] = 1;
        }
        for(int next : tree.get(num)){
            if(!visited[next]){
                visited[next] = true;
                tracking(next,ans[num]);
            }
        }
    }
}
