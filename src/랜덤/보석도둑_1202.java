package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 보석도둑_1202 {
    /**
     * 가방 기준 담을 수 있는 가장 큰거
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> nodeList = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int[] bag = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(weight, value));
        }


        for (int i = 0; i < K; i++) {
            int c = Integer.parseInt(br.readLine());
            bag[i] = c;
        }

        Arrays.sort(bag);

        long ans = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.value - a.value);

        for (int i = 0; i < K; i++) {
            //최대무게
            int c = bag[i];

            while (!nodeList.isEmpty()) {
                Node node = nodeList.peek();
                if (node.weight <= c)queue.add(nodeList.poll());
                else break;
            }

            if (!queue.isEmpty()) {
                ans += queue.poll().value;
            }
        }

        System.out.println(ans);
    }

    static class Node{
        int weight;
        int value;

        public Node(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
