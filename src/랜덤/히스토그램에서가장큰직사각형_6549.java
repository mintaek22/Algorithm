package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 히스토그램에서가장큰직사각형_6549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt;
        while((cnt = Integer.parseInt(st.nextToken())) != 0){
            int[] arr = new int[cnt];

            for (int i = 0; i < cnt; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            long ans  = 0;

            //오름차순 유지
            for (int i = 1; i < cnt; i++) {
                while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                    int height = arr[stack.pop()];
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    long width = i - left - 1;
                    ans = Math.max(ans, height * width);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()){
                int height = arr[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                long width = arr.length - left - 1;
                ans = Math.max(ans, height * width);
            }

            System.out.println(ans);

            st = new StringTokenizer(br.readLine());
        }

    }
}
