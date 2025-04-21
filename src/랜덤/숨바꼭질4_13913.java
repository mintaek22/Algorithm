package 랜덤;

import java.io.*;
import java.util.*;

public class 숨바꼭질4_13913 {

    static int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX];
        int[] prev = new int[MAX];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == K) break;

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next >= 0 && next < MAX && dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    prev[next] = cur;
                    queue.offer(next);
                }
            }
        }

        bw.write(dist[K] + "\n");

        Stack<Integer> path = new Stack<>();
        for (int i = K; i != N; i = prev[i]) {
            path.push(i);
        }
        path.push(N);

        while (!path.isEmpty()) {
            bw.write(path.pop() + " ");
        }

        bw.flush();
        bw.close();
    }
}