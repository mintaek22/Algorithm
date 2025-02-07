package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 투에모스문자열_18222 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long K = Long.parseLong(br.readLine());

        int n = 0;
        while (K > Math.pow(2,n) ) {
            n++;
        }

        long start = 1;
        long end = (long)Math.pow(2,n);

        boolean isReversed = false;
        while(start<end){
            long mid = (start+end)/2;
            if(K>mid){
                isReversed = !isReversed;
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        System.out.println(isReversed ? 1 : 0);
    }
}
