package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 오아시스재결합_3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long answer = 0;

        Stack<Integer> stack = new Stack<>();
        int[] sameCount = new int[N];
        Arrays.fill(sameCount,1);
        stack.push(0);
        for(int i=1;i<N;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                answer+=sameCount[stack.peek()];
                if(arr[stack.peek()]==arr[i]) sameCount[i] += sameCount[stack.peek()];
                stack.pop();
            }
            if(!stack.isEmpty()){
                answer++;
            }
            stack.push(i);
        }
        System.out.println(answer);
    }
}
