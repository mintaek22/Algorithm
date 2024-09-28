package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 예산_2512 {

    static int N;
    static int[] arr;
    static int account;
    static int start = 0;
    static int last = 0;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            last = Math.max(last,arr[i]);
        }

        account = Integer.parseInt(br.readLine());

        find();
        System.out.println(ans);
    }

    static void find(){
        while(start<=last){
            int n = (start+last)/2;
            if(isPossible(n)){
                start = n+1;
                ans = Math.max(ans,n);
            }
            else{
                last = n-1;
            }
        }
    }

    static boolean isPossible(int money){
        int remain = account;
        for (int request : arr) {
            remain -= Math.min(request, money);
            if (remain < 0) return false;
        }
        return true;
    }

}
