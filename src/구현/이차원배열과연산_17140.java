//package 구현;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class 이차원배열과연산_17140 {
//
//    static ArrayList<ArrayList<Integer>> arr;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int r = Integer.parseInt(st.nextToken());
//        int c = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//
//        for (int i = 0; i < 3; i++) {
//            st = new StringTokenizer(br.readLine());
//            arr.get(i).add(Integer.parseInt(st.nextToken()));
//            arr.get(i).add(Integer.parseInt(st.nextToken()));
//            arr.get(i).add(Integer.parseInt(st.nextToken()));
//        }
//
//        int time = 0;
//
//        while(time<100){
//            time++;
//
//            PriorityQueue<Point>
//            //R연산
//            if(arr.size()>=arr.get(0).size()){
//                for (int i = 0; i < arr.size(); i++) {
//                    ArrayList<Integer> row = arr.get(i);
//                    for (Integer num:row) {
//                        map.put(num,map.getOrDefault(num,0)+1);
//                    }
//                }
//            }
//            //C연산
//            else{
//
//            }
//        }
//
//        System.out.println(-1);
//
//    }
//
//    static class Point{
//        int num;
//        int count;
//
//        public Point(int num, int count) {
//            this.num = num;
//            this.count = count;
//        }
//    }
//}
