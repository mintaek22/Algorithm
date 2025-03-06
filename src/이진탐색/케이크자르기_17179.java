package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케이크자르기_17179 {

    static int[] count,point;
    static int N,M,L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        point = new int[M+1];
        for (int i = 0; i < M; i++) point[i] = Integer.parseInt(br.readLine());
        point[M]=L;

        count = new int[N];
        for (int i = 0; i < N; i++) count[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int cutCount = count[i];
            int start = 0;
            int end = L;
            int ans = 0;
            while(start<=end){
                int mid = (start+end)/2;
                if(isPossible(cutCount,mid)){
                    ans = mid;
                    start = mid+1;
                }
                else end = mid-1;
            }
            System.out.println(ans);
        }
    }

    static boolean isPossible(int cutCount,int minLength){
        int count = 0;
        int pre = 0;
        for (int i = 0; i < M+1; i++) {
            if (point[i] - pre >= minLength) {
                pre = point[i];
                count++;
            }
        }
        return count-1>=cutCount;
    }
}
