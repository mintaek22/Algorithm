package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 산책_22868 {

    static int n,m,s,e,ans;
    static ArrayList<ArrayList<Integer>> list;
    static int[] route;
    static boolean[] check;
    static class Vertex{
        int v;
        int c;
        public Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        route = new int[n+1];
        check = new boolean[n+1];

        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        st= new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++) Collections.sort(list.get(i));

        goWorking(s,e);
        Arrays.fill(check, false);

        int v = route[e];
        while(v>0) {
            check[v] = true;
            v = route[v];
        }
        check[s]=false;
        goWorking(e, s);
        System.out.println(ans);
    }

    public static void goWorking(int s, int e) {
        Queue<Vertex> q = new LinkedList<>();

        q.add(new Vertex(s,0));
        check[s] = true;

        while(!q.isEmpty()) {
            Vertex curV = q.poll();

            for(int v:list.get(curV.v)) {
                if(check[v]) continue;
                check[v] = true;
                route[v] = curV.v;
                q.add(new Vertex(v, curV.c+1));

                if(v == e) {
                    ans += curV.c+1;
                    return;
                }
            }

        }
    }
}
