package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 젊은날의생이여_18866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] minHappy = new int[n];
        int[] maxHappy = new int[n];
        int[] minTired = new int[n];
        int[] maxTired = new int[n];

        minHappy[0] = arr[0][0];
        maxTired[0] = arr[0][1];
        if(minHappy[0] == 0) minHappy[0] = Integer.MAX_VALUE;
        if(maxTired[0] == 0) maxTired[0] = 1;

        for (int i = 1; i < n; i++) {
            minHappy[i] = Math.min(minHappy[i - 1], arr[i][0]);
            maxTired[i] = Math.max(maxTired[i - 1], arr[i][1]);
            if(minHappy[i] == 0) minHappy[i] = minHappy[i - 1];
        }

        maxHappy[n-1] = arr[n-1][0];
        minTired[n-1] = arr[n-1][1];
        if(maxHappy[n-1] == 0) maxHappy[n-1] = 1;
        if(minTired[n-1] == 0) minTired[n-1] = Integer.MAX_VALUE;

        for (int i = n-2; i >= 0; i--) {
            maxHappy[i] = Math.max(maxHappy[i + 1], arr[i][0]);
            minTired[i] = Math.min(minTired[i + 1], arr[i][1]);
            if(minTired[i] == 0) minTired[i] = minTired[i + 1];
        }

        int ans = -1;
        for (int i = 0; i < n-1; i++) {
            if(minHappy[i] >= maxHappy[i+1] && maxTired[i] <= minTired[i+1]) ans = i+1;
        }

        System.out.println(ans);
    }
}
