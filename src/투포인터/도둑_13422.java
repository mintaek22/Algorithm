package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도둑_13422 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) arr[i] = Integer.parseInt(st.nextToken());
            for (int i = 1; i < N+1; i++) arr[i] += arr[i-1];

            int ans = 0;

            if (N == M) {
                int total = arr[N];
                if (total < K) ans = 1;
            }
            else {
                for(int start = 0; start < N; start++) {
                    int end = start + M;
                    int sum;
                    if(end <= N) sum = arr[end] - arr[start];
                    else sum = arr[N] - arr[start] + arr[end - N];
                    if(sum < K) ans++;
                }
            }

            System.out.println(ans);

        }
    }
}
