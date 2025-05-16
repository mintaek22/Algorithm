package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 도로정보_24548 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int[] TCount = new int[N+1];
        int[] GCount = new int[N+1];
        int[] FCount = new int[N+1];
        int[] PCount = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            char c = line.charAt(i-1);
            if(c == 'T') TCount[i]++;
            if(c == 'G') GCount[i]++;
            if(c == 'F') FCount[i]++;
            if(c == 'P') PCount[i]++;
        }

        //누적합
        for (int i = 1; i < N+1; i++) {
            TCount[i] += TCount[i - 1];
            GCount[i] += GCount[i - 1];
            FCount[i] += FCount[i - 1];
            PCount[i] += PCount[i - 1];
        }

        //3으로 나눈 나머지
        for (int i = 1; i < N+1; i++) {
            TCount[i]  = TCount[i] % 3;
            GCount[i]  = GCount[i] % 3;
            FCount[i]  = FCount[i] % 3;
            PCount[i]  = PCount[i] % 3;
        }

        int[][][][] remainCount = new int[3][3][3][3];

        for (int i = 0; i < N+1; i++) {
            remainCount[TCount[i]][GCount[i]][FCount[i]][PCount[i]]++;
        }

        int ans = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int count = remainCount[i][j][k][l];
                        ans += count*(count-1)/2;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
