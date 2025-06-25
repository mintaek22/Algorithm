package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 반도체설계_2352 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] bin = new int[N];
        int len = 0;
        for(int i=0;i<N;i++){
            int num = arr[i];
            int start = 0;
            int end = len-1;

            while(start <= end){
                int mid = (start + end)/2;
                if(bin[mid]<num){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            bin[start] = num;
            if (start == len) len++;
        }
        System.out.println(len);

    }
}
