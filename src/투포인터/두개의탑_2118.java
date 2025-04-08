package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 두개의탑_2118 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        for (int i = 1; i < N+1; i++) arr[i] = Integer.parseInt(br.readLine());
        for (int i = 1; i < N+1; i++) arr[i] += arr[i-1];

        int sum = arr[N];
        int standard = arr[N]/2;

        int start = 0;
        int end = 1;
        int ans = 0;
        while(start<end && end<=N){
            int gap = arr[end]-arr[start];
            if(gap>standard){
                gap = sum-gap;
                ans = Math.max(ans,gap);
                start++;
            }
            else{
                ans = Math.max(ans,gap);
                end++;
            }
        }
        System.out.println(ans);
    }
}
