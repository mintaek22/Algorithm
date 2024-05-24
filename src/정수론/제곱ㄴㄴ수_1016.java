package 정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 제곱ㄴㄴ수_1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] check = new boolean[(int)(max-min+1)];

        for(long i = min/2;i<=max;i++){
      //      System.out.println(Math.sqrt(i));
            if(i>1 && Math.sqrt(i) % (double) 1.0 == 0){
                for(long j = i;j<=max;j+=i) {
                    if (j > min) {
                        check[(int) (j-1)] = false;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < (int)(max-min+1); i++) {
            if (!check[i]) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
