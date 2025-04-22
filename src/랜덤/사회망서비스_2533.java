package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 사회망서비스_2533 {

    static ArrayList<ArrayList<Integer>> edgeList;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        /**
         * 인접한 노드가 모두 얼리 아답터일때만 아이디어 받아들임
         * 얼리아답터를 최소로 모든 사람이 아이디어
         * 사이클 X
         *
         * 자신의 인접노드가 모두 1이거나 자신이 1일때의 1의 최소 노드 수
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        edgeList = new ArrayList<>();
        for (int i = 0; i < N+1; i++) edgeList.add(new ArrayList<>());

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edgeList.get(a).add(b);
            edgeList.get(b).add(a);
        }

        dp = new int[N+1][2];
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int index){
        boolean isLeaf = true;

        dp[index][1] = 1;

        for(int child: edgeList.get(index)){
            if(!visited[child]){
                visited[child] = true;
                isLeaf = false;
                dfs(child);
                dp[index][1] += Math.min(dp[child][1],dp[child][0]);
                dp[index][0] += dp[child][1];
            }
        }

        if(isLeaf){
            dp[index][0] = 0;
            dp[index][1] = 1;
        }

    }
}
