package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카누선수_9007 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K =Integer.parseInt(st.nextToken());
            int N =Integer.parseInt(st.nextToken());

            int[][] arr = new int[4][N];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] sumArr1 = new int[N*N];
            int[] sumArr2 = new int[N*N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sumArr1[i+j*N] = arr[0][i] + arr[1][j];
                    sumArr2[i+j*N] = arr[2][i] + arr[3][j];
                }
            }

            Arrays.sort(sumArr1);
            Arrays.sort(sumArr2);

            int start = 0;
            int end = N*N-1;

            int diff = Integer.MAX_VALUE;
            int ans = 0;

            while(start<N*N && end>=0){
                int sum = sumArr1[start] + sumArr2[end];

                if(diff>Math.abs(sum-K)){
                    diff = Math.abs(sum-K);
                    ans = sum;
                }
                else if(diff == Math.abs(sum-K)){
                    ans = Math.min(sum, ans);
                }

                if(sum>K)end--;
                else start++;
            }

            System.out.println(ans);
        }
    }
}
