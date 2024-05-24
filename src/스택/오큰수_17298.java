package 스택;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //수열의 크기
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            bw.write(ans[i]+" ");
        }

        bw.flush();
        bw.close();
    }
}
