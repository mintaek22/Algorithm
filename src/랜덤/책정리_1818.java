package 랜덤;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 책정리_1818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N];
        int len = 1;
        lis[0] = arr[0];
        for (int i = 1; i < N; i++) {
            int left = 0;
            int right = len-1;
            int index = len;
            while(left<=right){
                int mid = (left+right)/2;
                if(lis[mid]>=arr[i]){
                    index = mid;
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }
            if(index == len){
                lis[len] = arr[i];
                len++;
            }
            else{
                lis[index] = arr[i];
            }
        }

        System.out.println(N-len);


    }
}
