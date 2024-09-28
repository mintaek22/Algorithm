package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기_1920 {

    static int N,M;
    static int[] arr1;
    static int[] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr1 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        arr2 = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        for (int i = 0; i < M; i++) {
            System.out.println(find(arr2[i]));
        }

    }

    static int find(int goal){
        int start = 0;
        int last = arr1.length-1;

        while(start <= last){
            int n = (start + last) / 2;
            int expect = arr1[n];

            if(expect == goal){
                return 1;
            }
            //커야한다
            else if(expect<goal){
                start = n+1;
            }
            else{
                last = n-1;
            }
        }
        return 0;
    }
}
