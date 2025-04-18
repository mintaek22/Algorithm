package 트리;

import java.io.*;
import java.util.Arrays;

public class 전화번호목록_5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] phone_number = new String[N];

            for (int i = 0; i < N; i++) {
                phone_number[i] = br.readLine();
            }
            Arrays.sort(phone_number);

            if (isConsistent(N, phone_number)) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isConsistent(int N, String[] phone_number) {
        for (int i = 0; i < N - 1; i++) {
            if (phone_number[i + 1].startsWith(phone_number[i])) {
                return false;
            }
        }

        return true;
    }
}

