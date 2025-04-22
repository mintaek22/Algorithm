package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 우수마을_1949 {

    static int[][] dp;
    static ArrayList<ArrayList<Integer>> edgeList;
    static boolean[] visited;
    static int[] score;

    public static void main(String[] args) throws IOException {
        /**
         * 사이클 X
         * 양방향 그래프
         * 우수 마을 끼리는 인접 X
         * 우수 마을이 아니면 하나의 우수마을과 인접
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        score = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            score[i]= Integer.parseInt(st.nextToken());
        }

         edgeList = new ArrayList<>();

        for (int i = 0; i < N+1; i++) edgeList.add(new ArrayList<>());

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edgeList.get(a).add(b);
            edgeList.get(b).add(a);
        }

        dp = new int[N+1][2];
        visited = new boolean[N+1];
        visited[1] = true;

        dfs(1);
        System.out.println(Math.max(dp[1][0],dp[1][1]));

    }

    static void dfs(int index){
        boolean isLeafNode = true;

        dp[index][1] = score[index];
        for(int child:edgeList.get(index)){
            if(!visited[child]){
                isLeafNode = false;
                visited[child] = true;
                dfs(child);
                dp[index][1] += dp[child][0];
                dp[index][0] += Math.max(dp[child][1], dp[child][0]);
            }
        }

        if(isLeafNode){
            dp[index][0] = 0;
            dp[index][1] = score[index];
        }
    }

}
