package 구현;

import java.io.*;

public class ZOAC_16719 {
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        selected = new boolean[str.length()];

        solve(str, 0, str.length() - 1);
    }

    static void solve(String str, int left, int right) throws IOException {
        if (left > right) return;

        int minIndex = left;
        for (int i = left; i <= right; i++) {
            if (str.charAt(i) < str.charAt(minIndex)) {
                minIndex = i;
            }
        }

        selected[minIndex] = true;
        printSelected(str);

        solve(str, minIndex + 1, right);
        solve(str, left, minIndex - 1);
    }

    static void printSelected(String str) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < str.length(); i++) {
            if (selected[i]) {
                bw.write(str.charAt(i));
            }
        }
        bw.newLine();
        bw.flush();
    }
}
