package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 휴게소세우기_1477 {

    static int N,M,L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N] = L;
        Arrays.sort(arr);
        int start = 1;
        int end  = L;
        int ans = 0;
        while(start <= end){
            int mid = (start+end)/2;
            if(isPossible(mid)){
                ans = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        System.out.println(ans);
    }

    static boolean isPossible(int distance){
        int count = 0;
        int cur = 0;
        int index = 0;
        while(index < N+1){
            if(arr[index]-cur>distance){
                count++;
                cur += distance;
                if(count>M) return false;
            }
            else{
                cur = arr[index];
                index++;
            }
        }
        return true;
    }
}
