package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        if(n<=2){
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int start;
            int end;
            if(i==0){
                start = 1;
                end = n-1;
            }
            else if(i == n-1){
                start = 0;
                end = n-2;
            }
            else{
                start = 0;
                end = n-1;
            }

            int sum = arr[start]+arr[end];

            //i는 key idx 이므로 예외처리
            while(start<end){
                if(sum==key){
                    answer++;
                    break;
                }
                else if(sum<key){
                    sum -= arr[start];
                    start++;
                    if(start == i) start++;
                    sum += arr[start];
                }
                else{
                    sum -= arr[end];
                    end--;
                    if(end == i) end--;
                    sum+= arr[end];
                }
            }
        }

        System.out.println(answer);

    }
}
