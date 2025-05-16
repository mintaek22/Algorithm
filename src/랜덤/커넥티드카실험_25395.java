package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 커넥티드카실험_25395 {

    static int N,S;
    static int[] location;
    static int[] energy;
    static int leftMax;
    static int rightMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        location = new int[N+1];
        energy = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) location[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) energy[i] = Integer.parseInt(st.nextToken());

        leftMax = location[S];
        rightMax = location[S];

        int leftLocation = location[S];
        int rightLocation = location[S];

        int leftIndex = S;
        int rightIndex = S;


        while(leftIndex>0 && rightIndex<N+1) {

            leftLocation = Math.min(leftLocation, location[leftIndex]-energy[leftIndex]);
            leftLocation = Math.min(leftLocation, location[rightIndex]-energy[rightIndex]);
            rightLocation = Math.max(rightLocation, location[leftIndex]+energy[leftIndex]);
            rightLocation = Math.max(rightLocation, location[rightIndex]+energy[rightIndex]);

            //확장 가능성
            boolean isPossible = false;

            //왼쪽 확장 가능 확인
            if(leftIndex>1 && location[leftIndex-1] >= leftLocation) {
                isPossible = true;
                leftIndex--;
            }

            //오른쪽 확장 가능 확인
            if(rightIndex<N && location[rightIndex+1] <= rightLocation) {
                isPossible = true;
                rightIndex++;
            }

            //더이상 확장 불가능
            if(!isPossible) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = leftIndex; i <= rightIndex; i++) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);

    }


}
