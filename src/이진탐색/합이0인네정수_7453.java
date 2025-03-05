package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이0인네정수_7453 {

    static int N;
    static int[] arr1,arr2,arr3,arr4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr1 = new int[N];
        arr2 = new int[N];
        arr3 = new int[N];
        arr4 = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
            arr3[i] = Integer.parseInt(st.nextToken());
            arr4[i] = Integer.parseInt(st.nextToken());
        }

        long[] arr12 = new long[N*N];
        long[] arr34 = new long[N*N];
        int index = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                arr12[index] = arr1[i]+arr2[j];
                arr34[index] = arr3[i]+arr4[j];
                index++;
            }
        }

        Arrays.sort(arr12);
        Arrays.sort(arr34);


        int start = 0;
        int end = N*N-1;
        long ans = 0;
        while(start<N*N && end>=0){
            long sum = arr12[start]+arr34[end];
            if(sum>0)end--;
            else if (sum<0) start++;
            else{
                int preStart = start;
                int preEnd = end;
                while(start < N*N && arr12[start] == arr12[preStart]) start++;
                while(end >=0 && arr34[end] == arr34[preEnd]) end--;
                ans += (long)(start-preStart)*(preEnd-end);
            }
        }
        System.out.println(ans);
    }
}
