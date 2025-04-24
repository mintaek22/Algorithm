package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class 냅색문제_1450 {

    static ArrayList<Integer> leftArr = new ArrayList<>();
    static ArrayList<Integer> rightArr = new ArrayList<>();

    static int[] left;
    static int[] right;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        left = Arrays.copyOfRange(arr,0,N/2);
        right =  Arrays.copyOfRange(arr,N/2,arr.length);

        dfs(0,0,false);
        dfs(0,0,true);

        Collections.sort(rightArr);

        long ans = 0;

        for (int leftSum : leftArr) {
            int start = 0;
            int end = rightArr.size() - 1;
            long cnt = 0;
            while (start <= end) {
                int mid = (start + end) / 2;

                //합이 C보다 작거나 같다
                if (rightArr.get(mid) + leftSum <= C) {
                    start = mid + 1;
                    //개수니까 index + 1
                    cnt = mid + 1L;
                } else {
                    end = mid - 1;
                }
            }

            ans += cnt;
        }

        System.out.println(ans);
    }

    static void dfs(int index,int sum,boolean isLeft){
        if(sum>C) return;

        if(isLeft){
            if(index == left.length){
                leftArr.add(sum);
                return;
            }
            //현재 index 추가
            dfs(index+1,sum+left[index],isLeft);

            //현재 미반영
            dfs(index+1,sum,isLeft);
        }
        else{
            if(index == right.length){
                rightArr.add(sum);
                return;
            }
            //현재 index 추가
            dfs(index+1,sum+right[index],isLeft);

            //현재 미반영
            dfs(index+1,sum,isLeft);
        }
    }
}
