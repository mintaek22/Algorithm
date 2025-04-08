package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 용액_2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;

        int[] ans = new int[2];
        int minGap = Integer.MAX_VALUE;

        while(start<end){
            int gap = Math.abs(arr[start]+arr[end]);
            if(minGap>gap){
                minGap = gap;
                ans[0] = arr[start];
                ans[1] = arr[end];
            }
            if(arr[start]+arr[end]<=0) start++;
            else end--;
        }

        System.out.print(ans[0]+" "+ans[1]);

    }
}
