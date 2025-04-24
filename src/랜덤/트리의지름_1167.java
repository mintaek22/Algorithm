package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의지름_1167 {

    static ArrayList<ArrayList<Edge>> tree;
    static int maxLen = 0;
    static int firstNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();

        for (int i = 0; i < V+1; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end;
            while((end = Integer.parseInt(st.nextToken())) != -1){
                int cost = Integer.parseInt(st.nextToken());
                tree.get(end).add(new Edge(start, cost));
                tree.get(start).add(new Edge(end, cost));
            }
        }

        int rootNode = 1;

        boolean[] visited = new boolean[V+1];
        visited[rootNode] = true;
        dfs(rootNode,visited,0);

        maxLen = 0;

        visited = new boolean[V+1];
        visited[firstNode] = true;
        dfs(firstNode,visited,0);

        System.out.println(maxLen);

    }

    static void dfs(int node,boolean[] visited,int sum){
        //리프 노드
        boolean isLeaf = true;

        for(Edge child : tree.get(node)){
            if(!visited[child.end]){
                visited[child.end] = true;
                isLeaf = false;
                dfs(child.end,visited,sum+child.cost);
            }
        }

        if(isLeaf){
            if(sum > maxLen){
                maxLen = sum;
                firstNode = node;
            }
        }
    }

    static class Edge{
        int end;
        int cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
