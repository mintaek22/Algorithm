package 조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항계수1_11050 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int num = fac(n)/(fac(n-k)*fac(k));
        System.out.println(num);
    }

    static int fac(int num){
        int result = 1;
        while(num>1){
            result *= num;
            num--;
        }
        return result;
    }
}
