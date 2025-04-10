package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 수열의구간평균_19566 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <N+1 ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            arr[i] += arr[i-1];
        }

        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < N+1; i++) {
            arr[i] = (long)K*i - arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0L) + 1);
        }

        long ans = 0;

        for(long key:map.keySet()){
            long count = map.get(key);
            ans += count*(count-1)/2;
        }

        System.out.println(ans);

    }
}
