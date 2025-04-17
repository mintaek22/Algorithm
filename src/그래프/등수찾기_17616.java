package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 등수찾기_17616 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> arrUp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrDown = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            arrUp.add(new ArrayList<>());
            arrDown.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrUp.get(b).add(a);
            arrDown.get(a).add(b);
        }

        int U = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(X);
        boolean[] visited = new boolean[N+1];
        visited[X] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next :arrUp.get(cur)){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    U++;
                }
            }
        }

        int V = N;

        q = new LinkedList<>();
        q.add(X);
        visited = new boolean[N+1];
        visited[X] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next :arrDown.get(cur)){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    V--;
                }
            }
        }

        System.out.println(U+" "+V);
    }
}
