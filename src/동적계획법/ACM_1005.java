package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACM_1005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] time = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();
            int[] degree = new int[N+1];

            for (int i = 0; i < N+1; i++) {
                edgeList.add(new ArrayList<>());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                edgeList.get(X).add(Y);
                degree[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            int[] dp = new int[N+1];
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <N+1 ; i++) {
                if(degree[i] == 0) {
                    q.add(i);
                    dp[i] = time[i];
                }
            }

            while (!q.isEmpty()) {
                int node = q.poll();

                if(node == W) break;

                for(int edge:edgeList.get(node)) {
                    degree[edge]--;
                    dp[edge] = Math.max(dp[edge], dp[node] + time[edge]);
                    if(degree[edge] == 0) {
                        q.add(edge);
                    }
                }
            }

            System.out.println(dp[W]);
        }
    }
}
