package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제추천시스템Version1_21939 {

    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        PriorityQueue<Node> maxQueue = new PriorityQueue<>(((o1, o2) -> {
            if(o1.level == o2.level){
                return o2.problem - o1.problem;
            }
            return o2.level - o1.level;
        }));
        PriorityQueue<Node> minQueue = new PriorityQueue<>(((o1, o2) -> {
            if(o1.level == o2.level){
                return o1.problem - o2.problem;
            }
            return o1.level - o2.level;
        }));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            if(!map.containsKey(P)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(L);
                map.put(P, list);
            }
            else{
                map.get(P).add(L);
            }
            Node node = new Node(P, L);
            maxQueue.add(node);
            minQueue.add(node);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            String operation = line[0];
            if(operation.equals("add")){
                int problem = Integer.parseInt(line[1]);
                int level = Integer.parseInt(line[2]);
                Node node = new Node(problem, level);
                if(!map.containsKey(problem)){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(level);
                    map.put(problem, list);
                }
                else{
                    map.get(problem).add(level);
                }
                maxQueue.add(node);
                minQueue.add(node);
            }
            else if(operation.equals("recommend")){
                int option = Integer.parseInt(line[1]);
                //어려운거
                if(option == 1){
                    System.out.println(getRecommend(maxQueue));
                }
                else{
                    System.out.println(getRecommend(minQueue));
                }
            }
            else{
                int problem = Integer.parseInt(line[1]);
                map.remove(problem);
            }
        }
    }

    static int getRecommend(PriorityQueue<Node> queue) {
        Node node = queue.peek();
        while(!queue.isEmpty()){
            if(map.containsKey(node.problem)){
                if(map.get(node.problem).contains(node.level))break;
            }

            queue.remove();
            node = queue.peek();
        }
        return node.problem;
    }

    static class Node{
        int problem;
        int level;

        public Node(int problem, int level) {
            this.problem = problem;
            this.level = level;
        }
    }
}
