package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 현욱은괄호왕이야_15926 {
    /**
     * ()
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        Stack<Integer> stack = new Stack<>();
        stack.add(-1);

        int answer = 0;
        String s = br.readLine();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.add(i);
            }
            else {
                stack.pop();
                if(!stack.isEmpty()) {
                    answer = Math.max(answer, i - stack.peek());
                }
                else {
                    stack.add(i);
                }
            }
        }
        System.out.print(answer);
    }
}
