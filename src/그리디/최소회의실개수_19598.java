package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소회의실개수_19598 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Node> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr.add(new Node(s, t));
        }

        arr.sort((o1,o2)-> o1.start- o2.start);

        PriorityQueue<Integer> endQueue = new PriorityQueue<>();
        endQueue.add(0);

        for (int i = 0; i < N; i++) {
            Node node = arr.get(i);
            if(!endQueue.isEmpty()){
                int end = endQueue.peek();
                if(node.start>=end) endQueue.poll();
                endQueue.add(node.end);
            }
        }
        System.out.println(endQueue.size());
    }

    static class Node{
        int start;
        int end;
        Node(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
}
