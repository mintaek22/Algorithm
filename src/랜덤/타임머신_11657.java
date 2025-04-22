package 랜덤;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 타임머신_11657 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(a, b, c));
        }

        long[] dp = new long[N + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[1] = 0;

        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edgeList) {
                if (dp[edge.start] != Long.MAX_VALUE && dp[edge.end] > dp[edge.start] + edge.cost) {
                    dp[edge.end] = dp[edge.start] + edge.cost;
                }
            }
        }

        for (Edge edge : edgeList) {
            if (dp[edge.start] != Long.MAX_VALUE && dp[edge.end] > dp[edge.start] + edge.cost) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (dp[i] == Long.MAX_VALUE) sb.append("-1\n");
            else sb.append(dp[i]).append("\n");
        }
        System.out.print(sb);    }

    static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
