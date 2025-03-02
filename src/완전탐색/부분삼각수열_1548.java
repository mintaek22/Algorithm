package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분삼각수열_1548 {

    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        if(N<3){
            System.out.println(N);
            return;
        }

        int ans = 2;
        for (int start = 0; start < N-2; start++) {
            int len = 2;
            for(int end = start+2; end < N; end++) {
                if(arr[start]+arr[start+1]>arr[end]) len++;
                else break;
            }
            ans = Math.max(ans, len);
        }

        System.out.println(ans);
    }
}
