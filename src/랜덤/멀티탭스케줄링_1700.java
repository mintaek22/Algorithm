package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 멀티탭스케줄링_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < K; i++) {
            int cur = arr[i];

            //이미 꽂혀있는 경우
            if(set.contains(cur)) continue;

            //구가 남아 있음
            if(set.size()<N){
                set.add(cur);
                continue;
            }

            //교체 대상 찾기
            HashSet<Integer> visited =new HashSet<>();
            for (int j = i+1; j < K; j++) {
                //하나만 남음
                if(visited.size()+1 == set.size()){
                    break;
                }

                if(set.contains(arr[j])){
                    visited.add(arr[j]);
                }
            }

            int target = -1;
            for (int key : set) {
                if (!visited.contains(key)) {
                    target = key;
                    break;
                }
            }

            set.remove(target);
            set.add(cur);
            ans++;
        }
        System.out.println(ans);
    }
}
