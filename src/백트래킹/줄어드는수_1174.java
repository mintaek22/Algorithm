package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 줄어드는수_1174 {

    static int N;
    static ArrayList<String> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int len = 1;
        while (N > 0) {
            int start = N;
            arr = new ArrayList<>();
            arr.add("10");
            dfs(len,0);
            len++;
            int end = N;
            if(start==end) {
                System.out.println(-1);
                return;
            }
        }
    }

    static public void dfs(int len,int depth){
        if(N == 0) return;
        if(len == depth){
            N--;
            if(N==0){
                for(String s:arr){
                    if(s.equals("10")) continue;
                    System.out.print(s);
                }
            }
        }
        if(depth == 0 && len > 1){
            for (int i = 1; i < 10; i++) {
                arr.add(String.valueOf(i));
                dfs(len,depth+1);
                arr.remove(arr.size()-1);
            }
        }
        else{
            for (int i = 0; i < Integer.parseInt(arr.get(arr.size()-1)); i++) {
                arr.add(String.valueOf(i));
                dfs(len,depth+1);
                arr.remove(arr.size()-1);
            }
        }

    }
}
