package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 흩날리는시험지속에서내평점이느껴진거야_17951 {

    static int[] arr;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int start  = 0;
        int end = 0;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            start = Math.min(start, num);
            end = Math.max(end, num);
        }
        end *= (N-K+1);

        int ans = 0;

        while(start<=end){
            int mid = (start+end)/2;
            boolean is = isPossible(mid);
            if(is){
                ans = mid;
                start = mid +1;
            }
            else{
                end = mid -1;
            }
        }

        System.out.println(ans);
    }

    static boolean isPossible(int predictScore){
        int sum = 0;
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum>=predictScore){
                cnt++;
                sum = 0;
            }
            if(cnt>=K) return true;
        }
        return false;
    }
}
