package 그래프;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이분그래프_1707 {

    static int[] visit;
    static ArrayList<ArrayList<Integer>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        loop:
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr = new ArrayList<>();
            for (int j = 0; j < v+1; j++) {
                arr.add(new ArrayList<>());
            }
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr.get(a).add(b);
                arr.get(b).add(a);
            }
            visit = new int[v + 1];
            Queue<Node> q = new LinkedList<>();
            for (int j = 1; j < v+1; j++) {
                if(visit[j] == 0){
                    q.add(new Node(j,1));
                    visit[j] = 1;
                }
                while (!q.isEmpty()) {
                    Node node = q.poll();
                    int new_mark;
                    if(node.mark == 1) new_mark = -1;
                    else new_mark = 1;
                    for (int new_point:arr.get(node.point)) {
                        if((visit[new_point] == 1 && new_mark == -1)
                        || (visit[new_point] == -1 && new_mark == 1)){
                            bw.write("NO\n");
                            continue loop;
                        }
                        if(visit[new_point] == 0){
                            q.add(new Node(new_point,new_mark));
                            visit[new_point] = new_mark;
                        }
                    }
                }
            }
            bw.write("YES\n");
        }
        bw.flush();
        bw.close();
    }

    static class Node{
        int point;
        int mark;

        public Node(int point, int mark) {
            this.point = point;
            this.mark = mark;
        }
    }
}
