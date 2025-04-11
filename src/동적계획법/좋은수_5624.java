package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 좋은수_5624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < N; i++) {
            for(int j=0;j<i;j++){
               set.add(arr[j] + arr[i-1]);
            }

            for(int j=0;j<i;j++){
                if(set.contains(arr[i] - arr[j])) {
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
