package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 우체국_2285 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   //위치
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;

            sum += b;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        long goal = (sum+1)/2;
        long cur = 0;
        long index = 0;
        for (int i = 0; i < N; i++) {
            cur += arr[i][1];
            if(cur>=goal) {
                index = arr[i][0];
                break;
            }
        }

        System.out.println(index);
    }
}
