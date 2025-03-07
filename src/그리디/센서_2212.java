package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 센서_2212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int len = arr[N-1]-arr[0];

        Integer[] gap = new Integer[N-1];
        for (int i = 0; i < N-1; i++) {
            gap[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(gap,(o1,o2)->o2-o1);

        for (int i = 0; i < Math.min(N-1,K-1); i++) {
            len -= gap[i];
        }

        System.out.println(len);
    }
}
