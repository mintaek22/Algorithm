package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 좋은수열_2661 {

    static int N;
    static String ans = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0,"");
        System.out.println(ans);
    }

    static void dfs(int depth,String str){
        if(!ans.isEmpty()) return;

        if(depth == N){
            ans = str;
            return;
        }

        for (int i = 1; i <=3 ; i++) {
            if(check(str+i)){
                dfs(depth+1,str+i);
            }
        }
    }

    static boolean check(String str){
        for (int i = 1; i <= str.length()/2; i++) {
            String tmp1 = str.substring(str.length()-i);
            String tmp2 = str.substring(str.length()-2*i,str.length()-i);
            if(tmp1.equals(tmp2)) return false;
        }
        return true;
    }
}
