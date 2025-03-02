package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의지름_1976 {

    static int ans = 0;
    static ArrayList<ArrayList<Node>> tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree.get(a).add(new Node(b,w));
            tree.get(b).add(new Node(a,w));
        }


        for (int i = 0; i < tree.size(); i++) {
            if(tree.get(i).size()==1){
                visited = new boolean[N+1];
                visited[i] = true;
                dfs(i,0);
            }
        }

        System.out.println(ans);
    }

    static void dfs(int node,int distance){
        ans = Math.max(ans,distance);
        ArrayList<Node> nodeList = tree.get(node);
        for (Node childNode : nodeList) {
            if (!visited[childNode.v]) {
                visited[childNode.v] = true;
                dfs(childNode.v, distance + childNode.w);
            }
        }
    }

    static class Node{
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
