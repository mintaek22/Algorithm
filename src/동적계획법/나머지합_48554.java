package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합_48554 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        int[] div = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<n+1;i++){
            dp[i] = (dp[i-1]+Integer.parseInt(st.nextToken()))%m;
            div[dp[i]]++;
        }

        //0은 이미 나누어 떨어지는 수
        long answer = div[0];
        for(int i=0;i<m;i++){
            if(div[i] > 1){
                answer += ((long) div[i] *(div[i]-1)/2);
            }
        }

        System.out.println(answer);
    }
}
