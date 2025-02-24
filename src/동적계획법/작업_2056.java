package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 작업_2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int[] timeList = new int[N+1];
        int[] degree = new int[N+1];
        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            timeList[i] = time;

            int preCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < preCount; j++) {
                int preNode = Integer.parseInt(st.nextToken());
                arr.get(i).add(preNode);
                degree[preNode]++;
            }
        }

        int[] dp = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
            if(degree[i] == 0) {
                q.add(i);
                dp[i] = timeList[i];
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for (int nextNode: arr.get(node)) {
                degree[nextNode]--;
                dp[nextNode] = Math.max(dp[nextNode],dp[node]+timeList[nextNode]);
                if(degree[nextNode] == 0) q.add(nextNode);
            }
        }

        int ans = 0;
        for (int i = 1; i < N+1; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

}

