package 랜덤;

import java.io.*;
import java.util.StringTokenizer;

public class 팰린드롬_10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] isPalindrome = new boolean[N+1][N+1];

        //홀수 시작점
        for(int i=1;i<N+1;i++){
            int start = i;
            int end = i;
            while(start>0 && end<N+1 && arr[start]==arr[end]){
                isPalindrome[start][end] = true;
                start--;
                end++;
            }
        }

        //짝수 시작점
        for(int i=1;i<N;i++) {
            int start = i;
            int end = i + 1;
            while (start > 0 && end < N + 1 && arr[start] == arr[end]) {
                isPalindrome[start][end] = true;
                start--;
                end++;
            }
        }
        int M = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if ((isPalindrome[S][E])) bw.append("1");
            else bw.append("0");
            bw.newLine();
        }

        bw.flush();
    }
}
