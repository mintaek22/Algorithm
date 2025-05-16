package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 스크루지민호2_12978 {

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N+1; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dp = new int[N+1][2];
        visited = new boolean[N+1];
        visited[1] = true;
        //1번을 루트로
        dfs(1);

        System.out.println(Math.min(dp[1][1],dp[1][0]));
    }

    static void dfs(int num){
        boolean isLeaf = true;

        dp[num][1] = 1;

        for(int next:tree.get(num)){
            if(!visited[next]){
                isLeaf = false;
                visited[next] = true;
                dfs(next);

                //경찰서 세움
                dp[num][1] += Math.min(dp[next][1], dp[next][0]);

                //경찰서 안세움
                dp[num][0] += dp[next][1];
            }
        }

        if(isLeaf){
            //경찰서 세운 경우
            dp[num][1] = 1;
            //경찰서 안 세운 경우
            dp[num][0] = 0;
        }


    }
}
