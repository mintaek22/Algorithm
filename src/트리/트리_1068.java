package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리_1068 {
    static private int n;
    static private ArrayList<ArrayList<Integer>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        int root = 0;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1){
                root = i;
                continue;
            }
            arr.get(parent).add(i);
        }

        int ans = bfs(root,Integer.parseInt(br.readLine()));

        System.out.println(ans);

    }

    static int bfs(int root,int remove){
        Queue<Integer> q = new LinkedList<>();
        int leafNode = 0;
        boolean[] visit = new boolean[n];
        q.add(root);
        visit[root] = true;
        visit[remove] = true;
        if(root == remove) return 0;
        while (!q.isEmpty()) {
            int parent = q.poll();
            boolean flag = true;
            for (int next: arr.get(parent)) {
                if(!visit[next]){
                    flag = false;
                    visit[next] = true;
                    q.add(next);
                }
            }
            if(flag) leafNode++;
        }

        return leafNode;
    }

}
