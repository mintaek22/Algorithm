package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기_2230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        while(start<=end && end<N){
            int gap = arr[end]-arr[start];
            if(gap>=M){
                if(ans>gap){
                    ans = gap;
                    start++;
                }
                else{
                    start++;
                }
            }
            else{
                end++;
            }
        }

        System.out.println(ans);
    }
}
