package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 줄어드는수_1174 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Queue<String> q= new LinkedList<>();
        q.add("");
        int count = -1;
        while(!q.isEmpty()){
            String s = q.poll();
            count++;
            if(count == N){
                System.out.println(s);
                return;
            }
            for (int i = 0; i <= 9 ; i++) {
                if(s.isEmpty()){
                    q.add(String.valueOf(i));
                }
                else{
                    if(Integer.parseInt(String.valueOf(s.charAt(s.length()-1)))>i){
                        q.add(s+i);
                    }
                    else break;
                }
            }
        }

        System.out.println(-1);
    }

}
