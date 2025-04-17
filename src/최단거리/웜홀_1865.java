package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 웜홀_1865 {

    static int[] distance;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TEST = Integer.parseInt(br.readLine());

        while(TEST-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            edgeList = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edgeList.add(new Edge(S, E, T));
                edgeList.add(new Edge(E, S, T));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edgeList.add(new Edge(S, E, -T));
            }

            boolean ans = false;


            distance = new int[N+1];

            for (int i = 1; i < N+1; i++) {
                for(Edge edge: edgeList){
                    int start = edge.start;
                    int end = edge.end;
                    int cost = edge.cost;
                    distance[end] = Math.min(distance[end],distance[start]+cost);
                }
            }

            for (int i = 1; i < N+1; i++) {
                for(Edge edge: edgeList){
                    int start = edge.start;
                    int end = edge.end;
                    int cost = edge.cost;
                    if(distance[end] > distance[start]+cost){
                        ans = true;
                        break;
                    }
                }
            }

            System.out.println(ans ? "YES" : "NO");
        }
    }


    static class Edge{
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
