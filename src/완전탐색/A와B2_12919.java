package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B2_12919 {
    static String s;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        String t = br.readLine();

        search(t);

        System.out.println(ans);
    }

    static void search(String str){
        if(str.equals(s)) {
            ans = 1;
            return;
        }

        if(ans == 1 || str.length() == 1) return;


        if(str.charAt(str.length()-1) == 'A'){
            search(str.substring(0,str.length()-1));
        }

        if(str.charAt(0) == 'B'){
            StringBuilder new_str = new StringBuilder();
            for (int i = str.length()-1; i >=1 ; i--) {
                new_str.append(str.charAt(i));
            }
            search(new_str.toString());
        }

    }
}
