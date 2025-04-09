package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문은회문아니야_15927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();

        boolean flag = false;
        int len = str.length();
        for(int i=0; i<len/2; i++) {
            if(str.charAt(i) != str.charAt(len-i-1)) {
                System.out.println(len);
                return;
            }
            else if(str.charAt(i) != str.charAt(i+1)) {
                flag = true;
            }

        }
        if(flag) {
            System.out.println(str.length()-1);
        }
        else {
            System.out.println(-1);
        }
    }
}
