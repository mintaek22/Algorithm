package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        String str = br.readLine();
        StringBuilder num = new StringBuilder();
        boolean minus = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '+'){
                if(minus){
                    ans -= Integer.parseInt(num.toString());
                }
                else{
                    ans += Integer.parseInt(num.toString());
                }
                num = new StringBuilder();
            }
            else if(c == '-'){
                if(minus){
                    ans -= Integer.parseInt(num.toString());
                }
                else{
                    ans += Integer.parseInt(num.toString());
                    minus = true;
                }
                num = new StringBuilder();
            }
            else{
                num.append(String.valueOf(c));
            }
        }
        if(minus){
            ans -= Integer.parseInt(num.toString());
        }
        else{
            ans += Integer.parseInt(num.toString());
        }

        System.out.println(ans);
    }
}
