package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 공항10775 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G+1];
        for (int i = 0; i < G+1; i++) parent[i] = i;

        int ans = 0;
        for (int i = 0; i < P; i++) {
            int gate = Integer.parseInt(br.readLine());
            if(find(gate) == 0) break;
            ans++;
            union(find(gate),find(gate)-1);

        }

        System.out.println(ans);
    }

    static void union(int a,int b){
        int rootA  = find(a);
        int rootB  = find(b);
        if(rootA != rootB) parent[rootA] = rootB;
    }

    static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
