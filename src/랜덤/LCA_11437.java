package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LCA_11437 {

    static HashMap<Integer,Integer> levelMap = new HashMap<>();
    static ArrayList<ArrayList<Integer>> tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i < N+1; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        parent = new int[N+1];
        parent[1] = -1;

        levelMap.put(1,0);
        dfs(1,0);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a,b)).append("\n");
        }
        System.out.println(sb);

    }


    static void dfs(int node,int level){
        for(int child:tree.get(node)){
            if(!levelMap.containsKey(child)){
                parent[child] = node;
                levelMap.put(child,level+1);
                dfs(child,level+1);
            }
        }
    }

    static int LCA(int a,int b){
        int aLevel = levelMap.get(a);
        int bLevel = levelMap.get(b);

         while (aLevel>bLevel){
             a = parent[a];
             aLevel--;
         }

        while (bLevel>aLevel){
            b = parent[b];
            bLevel--;
        }

        while(a != b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }


}
