package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 동전분배_1943 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());

            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int coin = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                map.put(coin, count);
                sum += coin * count;
            }

            if(sum%2 != 0) {
                System.out.println(0);
                continue;
            }

            boolean[] dp = new boolean[sum/2 + 1];
            dp[0] = true;
            for (int coin : map.keySet()) {
                int count = map.get(coin);
                int k = 1;
                while (count > 0) {
                    int use = Math.min(k, count);
                    int coinValue = coin * use;
                    for (int j = sum / 2; j >= coinValue; j--) {
                        if (dp[j - coinValue]) dp[j] = true;
                    }
                    count -= use;
                    k *= 2;
                }
            }
            System.out.println(dp[sum/2]?1:0);

        }
    }
}
