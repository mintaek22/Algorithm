package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴짝수연속한부분수열_2282 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        boolean[] isEven = new boolean[N];
        for(int i =0;i<N;i++){
            isEven[i] = Integer.parseInt(st.nextToken()) % 2 == 0;
        }

        int start = 0;
        int end = 0;
        int answer = 0;
        int tmp = 0;
        while(start<=end){
            if(end>=N) break;
            if(isEven[end]){
                end++;
                tmp++;
                answer = Math.max(answer,tmp);
            }
            else if(!isEven[end] && K>0){
                end++;
                K--;
            }
            else {
                if(isEven[start]){
                    tmp--;
                }
                else{
                    K++;
                }
                start++;
            }
        }

        System.out.println(answer);
    }
}
