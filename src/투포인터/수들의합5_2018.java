package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합5_2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = 1;
        int sum = 1;
        int answer = 0;

        while(start<=end) {
            if (sum == n) {
                answer++;
                sum -= start;
                start++;
            }
            //sum이 작으면
            else if (sum < n) {
                end++;
                sum += end;
            }
            //sum이 크면
            else {
                sum -= start;
                start++;
            }
        }

        System.out.println(answer);
    }
}
