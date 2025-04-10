package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나누기_21757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N+1; i++) arr[i] += arr[i-1];

        int sum = arr[N];

        if(sum % 4 != 0) {
            System.out.println(0);
            return;
        }

        int[] count1 = new int[N+1];
        for (int i = 1; i < N-2; i++) if(arr[i] == sum/4) count1[i] = 1;
        for (int i = 1; i < N-2; i++) count1[i] += count1[i-1];

        long[] count = new long[N+1];
        for (int i = 1; i < N-1; i++) if(arr[i] == sum/2) count[i] = count1[i-1];
        for (int i = 1; i < N-1; i++) count[i] += count[i-1];

        long ans = 0;
        for (int i = 1; i < N; i++) {
            if(arr[i] == sum*3/4){
                ans += count[i-1];
            }
        }
        System.out.println(ans);

    }
}
