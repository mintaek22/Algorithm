package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 블랙프라이데이_18114 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        //1개
        int start = 0;
        int end = N-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]>W){
                end = mid-1;
            }
            else if(arr[mid]<W){
                start = mid+1;
            }
            else{
                System.out.println(1);
                return;
            }
        }

        //2개
        start = 0;
        end = N-1;
        while(start<end){
            int sum = arr[start]+arr[end];
            if(sum>W) end--;
            else if(sum<W) start++;
            else{
                System.out.println(1);
                return;
            }
        }

        //3개

        for (int i = 0; i < N-2; i++) {
            start = i;
            int mid =i+1;
            end = N-1;
            while(mid<end){
                int sum = arr[start]+arr[mid]+arr[end];
                if(sum>W) end--;
                else if(sum<W) mid++;
                else{
                    System.out.println(1);
                    return;
                }
            }

        }

        System.out.println(0);

    }
}
