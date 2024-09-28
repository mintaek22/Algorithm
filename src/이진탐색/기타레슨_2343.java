package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨_2343 {

    static int N,M;
    static int[] arr;
    static int start = 0;
    static int last;

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            start = Math.max(start,num);
            last += num;
            arr[i] = num;
        }

        find();
        System.out.println(ans);
    }

    static void find(){
        while(start<=last){
            int n = (start+last)/2;
            if(isPossible(n)){
                last = n-1;
                ans = Math.min(ans,n);
            }
            else start = n+1;
        }
    }

    static boolean isPossible(int goal){
        int cnt = 1;
        int sum = 0;
        for (int j : arr) {

            sum += j;
            if (sum > goal) {
                cnt++;
                sum = j;
            }
        }
        return cnt <= M;
    }
}
