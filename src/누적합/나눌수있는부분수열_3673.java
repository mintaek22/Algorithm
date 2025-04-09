package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나눌수있는부분수열_3673 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T -- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long[] arr = new long[n+1];
            for (int i = 1; i < n+1; i++) arr[i] = Long.parseLong(st.nextToken());
            for (int i = 1; i < n+1 ; i++) arr[i] += arr[i-1];

            HashMap<Long, Long> map = new HashMap<>();

            for (int i = 0; i < n+1; i++) {
                map.put(arr[i] % d,map.getOrDefault(arr[i] % d,0L)+1);
            }

            long ans = 0;

            for (Long key : map.keySet()) {
                long count = map.get(key);
                ans+= count*(count-1)/2;
            }

            System.out.println(ans);


        }
    }
}
