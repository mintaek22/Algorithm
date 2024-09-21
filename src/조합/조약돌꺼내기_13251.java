package 조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조약돌꺼내기_13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //색상 수
        int m = Integer.parseInt(br.readLine());
        int[] color = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            color[i] = num;
            sum += num;
        }

        //뽑을 개수
        int k = Integer.parseInt(br.readLine());

        //전체 경우의 수
        double sumCnt =  combination(sum,k);

        //같은 색깔
        double sameColor = 0;
        for (int cnt:color) {
            if(cnt>=k){
                sameColor += combination(cnt,k);
            }
        }

        System.out.println(sameColor/sumCnt);
    }

    static double combination(int n,int k){
        double result = 1.0;
        int temp = k;
        while(temp>0){
            result *= n;
            temp--;
            n--;
        }
        while(k>0){
            result /= k;
            k--;
        }
        return result;
    }
}
