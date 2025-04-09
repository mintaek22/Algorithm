package 누적합;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동작그만밑장빼기냐_20159 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cards = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int[] oddSum = new int[N+1];
        int[] evenSum = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            oddSum[i] = oddSum[i-1];
            evenSum[i] = evenSum[i-1];
            if(i%2 == 0) evenSum[i] += cards[i];
            else oddSum[i] += cards[i];
        }

        int ans = 0;

        for (int i = 1; i < N+1; i++) {
            if(i%2 == 0){
                int sum = oddSum[i] + evenSum[N-1]-evenSum[i-1];
                ans = Math.max(ans, sum);
            }
            else{
                int sum = oddSum[i-1] + evenSum[N]-evenSum[i];
                ans = Math.max(ans, sum);
            }
        }

        System.out.println(ans);

    }
}
