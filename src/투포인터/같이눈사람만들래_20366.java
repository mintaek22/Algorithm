package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 같이눈사람만들래_20366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = Integer.MAX_VALUE;
        int[] arr = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i+2; j < N; j++) {
                int start = i+1;
                int end = j+1;
                while(start<j && end<N){
                    int gap1 = arr[start]-arr[i];
                    int gap2 = arr[end]-arr[j];
                    ans = Math.min(ans,Math.abs(gap1-gap2));
                    if(gap1>=gap2) end++;
                    else start++;
                }
            }
        }

        System.out.println(ans);
    }
}
