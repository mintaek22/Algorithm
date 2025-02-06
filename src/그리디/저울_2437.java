package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 저울_2437 {

    static Integer[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        weight = new Integer[N];

        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            weight[i] = num;
        }
        Arrays.sort(weight);

    }

}
