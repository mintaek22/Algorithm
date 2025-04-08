package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다이어트_1484 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double G = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 2;
        boolean flag = false;
        while(start<end){
            double gap = Math.pow(end,2)-Math.pow(start,2);
            if(G == gap){
                System.out.println(end);
                flag = true;
            }
            if(G<=gap) start++;
            else end++;
        }
        if(!flag) System.out.println(-1);
    }
}
