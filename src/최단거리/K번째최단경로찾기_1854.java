//package 다익스트라;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class K번째최단경로찾기_1854 {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//
//        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
//        for (int i = 0; i < n + 1; i++) {
//            arr.add(new ArrayList<>());
//        }
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());
//            arr.get(a).add(new Node(b, c));
//        }
//        int start = 1;
//        ArrayList<PriorityQueue<Integer>> distance = new ArrayList<>();
//        for (int i = 0; i < n+1; i++) {
//            distance.add(new PriorityQueue<>());
//        }
//
//        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
//        q.add(new Node(start,0));
//        while (!q.isEmpty()) {
//            Node now = q.poll();
//            for (Node next :arr.get(now.end)) {
//                if(distance.get(next.end).peek() >distance.get(now.end).peek()+ now.weight){
//
//                }
//            }
//        }
//
////        for (int i = 1; i < n+1; i++) {
////            if(!visit[i]) System.out.println(-1);
////            else System.out.println(distance[i]);
////        }
//
//    }
//
//    private static class Node{
//        int end;
//        int weight;
//
//        public Node(int end, int weight) {
//            this.end = end;
//            this.weight = weight;
//        }
//    }
//}
