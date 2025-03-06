package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 놀이공원_1561 {

    static long N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        arr = new int[(int)M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) arr[i] = Integer.parseInt(st.nextToken());

        if(N<=M){
            System.out.println(N);
            return;
        }

        long start = 0;
        long end =  N* 30;
        long time = 0;

        while(start<=end){
            long mid =  (start + end)/2;
            long count = getCount(mid);
            if(count>=N){
                end = mid-1;
                time = mid;
            }
            else{
                start = mid+1;
            }
        }

        long totalBefore = getCount(time - 1);
        long cur = totalBefore + 1;

        for (int i = 0; i < M; i++) {
            if (time % arr[i] == 0) {
                if (cur == N) {
                    System.out.println(i + 1);
                    return;
                }
                cur++;
            }
        }
    }

    static long getCount(long time){
        long count = M;
        for (int i = 0; i < M; i++) {
            count += time/arr[i];
        }
        return count;
    }
}
