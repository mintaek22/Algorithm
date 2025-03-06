package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이와가위_20444 {

    static long N;
    static long K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        if(find()) System.out.println("YES");
        else System.out.println("NO");
    }

    static boolean find(){
        long start  = 0;
        long end = N/2;
        while(start<=end){
            long x = (start+end)/2;
            long y = N-x;
            long num =(x+1)*(y+1);
            if(num > K){
                end = x-1;
            }
            else if(num < K){
                start = x+1;
            }
            else return true;
        }
        return false;
    }
}
