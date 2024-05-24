//package 위상정렬;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class 임계경로구하기_1948 {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int m = Integer.parseInt(br.readLine());
//
//        int[] d = new int[n+1];
//        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
//        for (int i = 0; i < n+1; i++) {
//            arr.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < m; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int finish = Integer.parseInt(st.nextToken());
//            arr.get(start).add(new Node(finish,Integer.parseInt(st.nextToken())));
//            d[finish]++;
//        }
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int goalStart = Integer.parseInt(st.nextToken());
//        int goalFinish = Integer.parseInt(st.nextToken());
//
//        Queue<Integer> q = new LinkedList<>();
//        for (int i = 1; i < n+1; i++) {
//            if(d[i] == 0) q.add(i);
//        }
//        int[] time = new int[n+1];
//        for (int i = 0; i < n+1; i++) {
//            time[i] = Integer.MAX_VALUE;
//        }
//
//        HashSet<Integer> ans = new HashSet<>();
//        while (!q.isEmpty()){
//            int start = q.poll();
//            for (Node node: arr.get(start)) {
//                int next = node.city;
//                if(time[next]>time[start]+node.weight){
//                    ans.add(start);
//                    time[next] = time[start]+node.weight;
//                }
//                time[next] = Math.min(time[next],time[start]+node.weight);
//            }
//        }
//
//
//
//
//    }
//    static private class Node{
//        int city;
//        int weight;
//
//        public Node(int city, int weight) {
//            this.city = city;
//            this.weight = weight;
//        }
//    }
//}
