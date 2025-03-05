package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간나누기2_13397 {

    static int[] arr;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }
        int ans = 0;
        while(start <= end){
            int mid = (start + end) / 2;


            if(blockCount(mid)) {
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }

        System.out.println(ans);

    }

    static boolean blockCount(int boundary){
        int count = 0;
        int index = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        while(index<N){
            max = Math.max(max, arr[index]);
            min = Math.min(min, arr[index]);
            if(max-min>boundary){
                min = Integer.MAX_VALUE;
                max = 0;
                count++;
            }
            else index++;
        }
        count++;
        return count <= M;
    }
}
