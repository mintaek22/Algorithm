package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속합2_13398 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        ArrayList<Integer> isMinus = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            if(num<0) isMinus.add(i);
        }

        int answer;
        int[] sumArr = new int[N+1];
        sumArr[0] = 0;
        for(int i = 1; i < N+1; i++){
            sumArr[i] = sumArr[i-1] + arr[i-1];
        }
        answer = sumArr[N];

        for(int index:isMinus){
            int[] tmpArr1 = Arrays.copyOfRange(sumArr, 0, index);
            int[] tmpArr2 =  Arrays.copyOfRange(sumArr, index+1, N+1);
            Arrays.sort(tmpArr1);
            Arrays.sort(tmpArr2);
            if(index == 0){
                answer = Math.max(answer, tmpArr2[tmpArr2.length-1] - arr[index]);
            }
            else if(index == N){
                answer = Math.max(answer, tmpArr1[tmpArr1.length-1]);
            }
            else{
                answer = Math.max(answer, tmpArr2[tmpArr2.length-1] - tmpArr1[0] - arr[index]);
            }
        }

        System.out.println(answer);
    }
}
