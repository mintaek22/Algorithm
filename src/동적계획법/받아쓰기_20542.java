package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 받아쓰기_20542 {


    //i = i,j,l v = v,w
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        String a = br.readLine();

        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(check(s.charAt(i-1),a.charAt(j-1))) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1])+1;
            }
        }

        System.out.println(dp[n][m]);
    }

    static boolean check(char a,char b){
        if(a==b) return true;
        if(a == 'i' && ((b== 'j') || (b== 'l'))) return true;
        return a == 'v' && ((b == 'w'));
    }
}

