package 그리디;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 크게만들기_2812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String number = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(stack.isEmpty()){
                stack.push(number.charAt(i));
            }
            else{
                while(k>0 && !stack.isEmpty() && stack.peek() < number.charAt(i)){
                    stack.pop();
                    k--;
                }
                stack.push(number.charAt(i));
            }
        }

        while(k>0) {
            stack.pop();
            k--;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (char c:stack) {
            bw.write(c);
        }

        bw.flush();

    }
}
