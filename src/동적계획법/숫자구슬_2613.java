package 동적계획법;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 숫자구슬_2613 {

    static int[] arr;
    static int N,M;
    static ArrayList<Integer> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = N*100;
        int ans = 0;
        while(start <= end){
            int mid = (start + end)/2;
            boolean isPossible = check(mid);
            if(isPossible){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        System.out.println(ans);

        ArrayList<Integer> result = new ArrayList<>();

        int nowSize = arrayList.size();

        for (int i = 0; i < arrayList.size(); i++) {
            int num = arrayList.get(i);
            while(nowSize<M && num>1){
                nowSize++;
                num--;
                result.add(1);
            }
            result.add(num);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int num:result) {
            bw.append(String.valueOf(num)).append(" ");
        }
        bw.flush();

    }

    static boolean check(int num){
        int count = 1;
        int sum = 0;
        int temp = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(arr[i] > num) return false;

            sum += arr[i];
            if(sum>num){
                count++;
                list.add(temp);
                temp = 1;
                sum = arr[i];
            }
            else temp++;
            if(count>M) return false;
        }
        list.add(temp);
        arrayList = list;
        return true;
    }
}
