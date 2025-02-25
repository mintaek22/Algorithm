package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 팰린드롬만들기_1695 {

    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
            dp[i][i] = 0;
        }

        System.out.println(search(0,N-1));
    }

    static int search(int left,int right){
        if(left >= right) return 0;
        if(dp[left][right]!=-1) return dp[left][right];

        if(arr[left] == arr[right]){
            dp[left][right] = search(left+1,right-1);
        }
        else{
           dp[left][right] = Math.min(search(left+1,right),search(left,right-1))+1;
        }

        return dp[left][right];
    }
}
