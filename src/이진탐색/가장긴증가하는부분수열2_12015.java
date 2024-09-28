package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2_12015 {

    static int N;
    static int[] arr;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list.add(arr[0]);
        for (int i = 1; i < N; i++) {
            int head = list.get(list.size()-1);
            int now = arr[i];
            if(now>head) list.add(now);
            else if(now<head){
                find(now);
            }
        }

        System.out.println(list.size());
    }

    static void find(int num){
        int start = 0;
        int last = list.size()-1;

        while(start<=last){
            int n = (start+last)/2;
            if(list.get(n)<num){
                start = n+1;
            }
            else if(list.get(n)>num){
                last = n-1;
            }
            else{
                return;
            }
        }

        if(start<list.size()){
            list.set(start,num);
        }
        else{
            list.set(last,num);
        }
    }
}
