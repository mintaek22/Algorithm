package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팀빌딩_22945 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N-1;
        int ans = 0;
        while(end-start>1){
            int score = (end-start-1) * Math.min(arr[start],arr[end]);
            ans = Math.max(score,ans);
            if(arr[start]<=arr[end]) start++;
            else end--;
        }

        System.out.println(ans);
    }
}
