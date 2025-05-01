package 랜덤;

import java.io.*;
import java.util.*;

public class 장난감조립_2637 {

    static boolean[] visited;
    static int[][] dp;
    static ArrayList<ArrayList<Node>> arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        for (int i = 0; i < N+1; i++) arr.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            arr.get(X).add(new Node(Y,K));
        }

        visited = new boolean[N+1];
        dp = new int[N+1][N+1];

        dfs(N);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1;i<N+1;i++){
            if(dp[N][i] > 0){
                bw.append(String.valueOf(i)).append(" ").append(String.valueOf(dp[N][i])).append("\n");
            }
        }

        bw.flush();

    }

    static void dfs(int num){
        visited[num] = true;

        //기본 재료
        if(arr.get(num).isEmpty()){
            dp[num][num] = 1;
        }

        for (Node node : arr.get(num)) {
            if(!visited[node.num]) dfs(node.num);
            for (int i = 1; i < N+1; i++) {
                dp[num][i] += dp[node.num][i] * node.cnt;
            }
        }
    }



    static class Node{
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
