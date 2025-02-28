package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 샘터_18513 {

    static Set<Long> visited = new HashSet<>();
    static int N,K;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            q.add(new Node(num,0,true));
            q.add(new Node(num,0,false));
            visited.add(num);
        }

        ans = 0L;
        while (!q.isEmpty()) {
            Node node = q.poll();

            long new_index = node.index+((node.front)?1:-1);

            if(!visited.contains(new_index)){
                visited.add(new_index);
                q.add(new Node(new_index,node.distance+1,node.front));
                ans += node.distance+1;
                K--;
            }

            if(K == 0) break;
        }

        System.out.println(ans);

    }

    static class Node{
        long index;
        long distance;
        boolean front;

        public Node(long index, long distance, boolean front) {
            this.index = index;
            this.distance = distance;
            this.front = front;
        }
    }
}
