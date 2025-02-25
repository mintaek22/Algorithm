package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수확_1823 {

    static int[] arr;
    static int[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N][N];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(dfs(0, N - 1));
    }

    static int dfs(int start, int end) {
        if (start > end) return 0;
        if (dp[start][end] != -1) return dp[start][end];

        int turn = N - (end - start);

        int left = dfs(start + 1, end) + arr[start] * turn;
        int right = dfs(start, end - 1) + arr[end] * turn;

        return dp[start][end] = Math.max(left, right);
    }
}
