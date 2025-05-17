package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬분할_1509 {

    static char[] line;
    static boolean [][] isPalindrome;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine().toCharArray();

        isPalindrome = new boolean[line.length][line.length];


        //길이가 1인건 다 팰린드롬
        for (int i = 0; i < line.length; i++) {
            isPalindrome[i][i] = true;
        }

        //길이가 2
        for (int i = 0; i < line.length-1; i++) {
            if(line[i] == line[i+1]) isPalindrome[i][i+1] = true;
        }

        for(int len = 3;len<=line.length;len++) {
            for (int i = 0; i < line.length; i++) {
                int j = i+len-1;
                //범위 넘김
                if(j>=line.length) break;
                if(line[i] == line[j] && isPalindrome[i+1][j-1]) isPalindrome[i][j] = true;
            }
        }

        int[] dp = new int[line.length];
        dp[0] = 1;

        for (int i = 1; i < line.length; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 0; j <= i; j++) {
                if(isPalindrome[j][i]) {
                    if(j == 0)  dp[i] = 1;
                    else dp[i] = Math.min(dp[i],dp[j-1] + 1);
                }
            }
        }

        System.out.println(dp[line.length-1]);
    }
}
