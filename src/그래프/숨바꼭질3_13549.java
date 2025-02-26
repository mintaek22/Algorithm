package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {

    static int min = Integer.MAX_VALUE;
    static int n, k;
    static boolean[] visited;
    static int max = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[max + 1];
        bfs();
    }

    public static void bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->o1.time-o2.time);
        q.offer(new Node(n, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            visited[node.x] = true;
            if(node.x == k) {
                System.out.println(node.time);
                return;
            };

            if(node.x * 2 <= max && !visited[node.x * 2]) q.add(new Node(node.x * 2, node.time));
            if(node.x + 1 <= max && !visited[node.x + 1]) q.add(new Node(node.x + 1, node.time + 1));
            if(node.x - 1 >= 0 && !visited[node.x - 1]) q.add(new Node(node.x - 1, node.time + 1));
        }
    }

    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
