package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 꿀따기_21758 {

    static int ans = 0;
    static int[] honeyList;
    static int N;
    static int[] leftSum;
    static int[] rightSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        honeyList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            honeyList[i] = Integer.parseInt(st.nextToken());
        }

        rightHoney();
        leftHoney();
        midHoney();

        System.out.println(ans);
    }

    public static void rightHoney(){
        leftSum = new int[N];
        leftSum[0] = honeyList[0];
        for (int i = 1; i < N; i++) {
            leftSum[i] = leftSum[i - 1] + honeyList[i];
        }

        for (int i = 1; i < N-1; i++) {
            int a = leftSum[N-1] - leftSum[0] - honeyList[i];
            int b = leftSum[N-1] - leftSum[i];
            ans = Math.max(ans, a+b);
        }
    }

    public static void leftHoney(){
        rightSum = new int[N];
        rightSum[N-1] = honeyList[N-1];
        for (int i = N-2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + honeyList[i];
        }

        for (int i = N-2; i > 0; i--) {
            int a = rightSum[0] - rightSum[N-1] - honeyList[i];
            int b = rightSum[0] - rightSum[i];
            ans = Math.max(ans, a+b);
        }
    }

    public static void midHoney(){
        for (int i = 1; i < N-1; i++) {
            int a = leftSum[i] - leftSum[0];
            int b = rightSum[i] - rightSum[N-1];
            ans = Math.max(ans, a+b);
        }
    }
}
