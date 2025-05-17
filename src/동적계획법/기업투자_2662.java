package 동적계획법;

import java.io.*;
import java.util.StringTokenizer;

public class 기업투자_2662 {

    static int[][] arr;
    static int[][] dp;
    static int N,M;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int j = 0; j < M; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[M][N+1];
        for (int i = 0; i < N+1; i++) dp[0][i] = arr[0][i];

        for(int i=1;i<M;i++){
            //이전 금액
            for (int j = 0; j < N+1; j++) {
                //추가할 금액
                for (int k = 0; k < N+1; k++) {
                    if(j+k>N) break;
                    dp[i][j+k] = Math.max(dp[i][j+k],dp[i-1][j] + arr[i][k]);
                }
            }
        }

        int maxValue = 0;
        int lastCost = 0;

        for(int i=0;i<N+1;i++){
            if(maxValue<dp[M-1][i]){
                maxValue = dp[M-1][i];
                lastCost = i;
            }
        }

        result = new int[M];
        tracking(M-1,lastCost);

        System.out.println(maxValue);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<M;i++){
            bw.append(String.valueOf(result[i])).append(" ");
        }
        bw.flush();
    }

    static void tracking(int num,int value){
        if(num == 0){
            result[num]=value;
            return;
        }

        //0이면 투자안함
        for (int j = 0; j <= value; j++) {
            int newValue = arr[num][j];
            if(dp[num][value] == dp[num-1][value-j] + newValue){
                result[num]=j;
                tracking(num-1,value-j);
                break;
            }
        }
    }

}
