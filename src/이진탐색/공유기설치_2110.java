package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110 {


    static int N,C;
    static int[] house;
    static int[] diff;
    static int start = Integer.MAX_VALUE;
    static int last = 0;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        diff = new int[N-1];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int before = house[0];
        for (int i = 1; i < N; i++) {
            diff[i-1] = house[i]-before;
            before = house[i];
            start = Math.min(diff[i-1],start);
            last += diff[i-1];
        }

        find();

        System.out.println(ans);
    }

    static void find(){
        while(start<=last){
            int n = (start+last)/2;
            if(isPossible(n)){
                start = n+1;
                ans = Math.max(ans,n);
            }
            else{
                last = n - 1;
            }
        }
    }

    static boolean isPossible(int distance){
        int cnt = 1;
        int sum = 0;
        for (int num:diff) {
            sum+= num;
            if(sum>=distance){
                cnt++;
                sum=0;
                if(cnt >= C) return true;
            }
        }
        return false;
    }
}
