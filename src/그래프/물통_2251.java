package 그래프;

import java.io.*;
import java.util.*;

public class 물통_2251 {

    static int[] bucket;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        bucket = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        boolean[][] visit = new boolean[201][201];
        HashSet<Integer> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        visit[0][bucket[2]] = true;
        q.add(new Node(0,0,bucket[2]));
        while (!q.isEmpty()) {
            Node node = q.poll();
            if(node.score[0] == 0) set.add(node.score[2]);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Node newNode = new Node(node.score[0],node.score[1],node.score[2]);
                    newNode.move(i,j);
                    if(i!=j){
                        if(!visit[newNode.score[1]][newNode.score[2]]){
                            visit[newNode.score[1]][newNode.score[2]] = true;
                            q.add(newNode);
                        }
                    }
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        for (int num: ans) {
            bw.write(num+" ");
        }
        bw.flush();
        bw.close();
    }

    static private class Node{
        int[] score;
        public Node(int a,int b,int c) {
            this.score = new int[]{a,b,c};
        }

        public void move(int from,int to){
            score[to] += score[from];
            score[from] = 0;
            //물 넘침
            if(score[to]>bucket[to]){
                score[from] = score[to]-bucket[to];
                score[to] = bucket[to];
            }
        }
    }
}
