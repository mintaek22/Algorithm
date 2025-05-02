package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 소가길을건너간이유4_14464 {

    static int C;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] chickens = new int[C];
        for (int i = 0; i < C; i++) {
            chickens[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.end- b.end);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.add(new Node(a, b));
        }

        Arrays.sort(chickens);
        System.out.println(process(chickens, pq));
    }


    private static int process(int[] chickens, PriorityQueue<Node> pq) {

        int cnt = 0;

        while(!pq.isEmpty()) {

            boolean isHelp = false;
            for (int i = 0; i < C; i++) {
                // 닭의 도움을 받아 소가 길을 건널 수 있다면
                if(chickens[i] >= pq.peek().start && chickens[i] <= pq.peek().end && chickens[i] > 0) {
                    cnt++;
                    pq.poll();
                    isHelp = true;
                    chickens[i] = -1;

                    break;
                }
            }
            // 소가 도움을 받을 수 없을 경우
            if(!isHelp) pq.poll();
        }

        return cnt;
    }

    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
