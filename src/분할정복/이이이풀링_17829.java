package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이이이풀링_17829 {

    static int[][] beforeMap;
    static int [][] newMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        beforeMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                beforeMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(N>1){
            newMap = new int[N/2][N/2];
            for (int i = 0; i < N/2; i++) {
                for(int j=0;j<N/2;j++){
                    int a = beforeMap[i*2][j*2];
                    int b = beforeMap[i*2][(j*2)+1];
                    int c = beforeMap[(i*2)+1][j*2];
                    int d = beforeMap[(i*2)+1][(j*2)+1];

                    int[] arr = {a,b,c,d};
                    Arrays.sort(arr);

                    int result = arr[2];

                    newMap[i][j] = result;
                }
            }
            beforeMap = new int[N/2][N/2];
            for (int i = 0; i < N/2; i++) {
                beforeMap[i] = newMap[i].clone();
            }
            N = N/2;
        }

        System.out.println(beforeMap[0][0]);
    }
}
