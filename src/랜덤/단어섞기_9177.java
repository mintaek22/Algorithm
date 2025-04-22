package 랜덤;

import java.io.*;
import java.util.StringTokenizer;

public class 단어섞기_9177 {

    static String a, b, c;
    static boolean[][] visited;
    static boolean isSuccess;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();
            c = st.nextToken();

            isSuccess = false;
            visited = new boolean[a.length() + 1][b.length() + 1];

            dfs(0, 0);

            bw.append("Data set ").append(String.valueOf(i)).append(": ");
            bw.append(isSuccess ? "yes" : "no").append("\n");
        }

        bw.flush();
    }

    static void dfs(int aIndex, int bIndex) {
        if (isSuccess || visited[aIndex][bIndex]) return;
        visited[aIndex][bIndex] = true;

        int cIndex = aIndex + bIndex;
        if (cIndex == c.length()) {
            isSuccess = true;
            return;
        }

        if (aIndex < a.length() && a.charAt(aIndex) == c.charAt(cIndex)) {
            dfs(aIndex + 1, bIndex);
        }
        if (bIndex < b.length() && b.charAt(bIndex) == c.charAt(cIndex)) {
            dfs(aIndex, bIndex + 1);
        }
    }
}
