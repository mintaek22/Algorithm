package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 연료채우기_1826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> distanceQ = new PriorityQueue<>((a,b) -> a.distance-b.distance);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            distanceQ.add(new Node(distance,value));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int maxDistance = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> valueQ = new PriorityQueue<>((a,b)->b.value-a.value);

        int ans = 0;

        //마을까지 갈 수 없을 동안
        while (maxDistance < L) {
            //갈 수 있는 주유소 넣기
            while (!distanceQ.isEmpty()) {
                Node node = distanceQ.peek();
                if (node.distance <= maxDistance) {
                    valueQ.add(distanceQ.poll());
                }
                else break;
            }
            if(!valueQ.isEmpty()){
                maxDistance += valueQ.poll().value;
                ans++;
            }
            //도달할 수 없음
            else{
                ans = -1;
                break;
            }
        }

        System.out.println(ans);

    }

    static class Node{
        int distance;
        int value;

        public Node(int distance, int value) {
            this.distance = distance;
            this.value = value;
        }
    }
}