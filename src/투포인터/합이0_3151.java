package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이0_3151 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N<3){
            System.out.println(0);
            return;
        }

        Arrays.sort(arr);

        long answer = 0L;

        for (int mid = 1; mid < N-1; mid++) {
            int first = 0;
            int last = N-1;
            while(first<mid && last>mid){
                int score = arr[first] + arr[mid] + arr[last];
                if(score>0) last--;
                else if(score<0) first++;
                else {
                    int tmpFirst = first+1;
                    int tmpLast = last-1;
                    while (tmpFirst < mid) {
                        if(arr[tmpFirst] == arr[first]){
                            tmpFirst++;
                        }
                        else break;
                    }

                    while (tmpLast > mid) {
                        if(arr[tmpLast] == arr[last]){
                            tmpLast--;
                        }
                        else break;
                    }

                    int sameCount = (tmpFirst-first) * (last-tmpLast);

                    first = tmpFirst;
                    last = tmpLast;

                    answer+=sameCount;

                }
            }
        }

        System.out.println(answer);

    }
}
