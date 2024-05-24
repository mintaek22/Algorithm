package 그래프;

import java.io.*;
import java.util.StringTokenizer;

public class 집합의표현_1717 {

    static private int[] map;
    static private BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            map[i] = i;
        }

        //0은 union
        //1은 find
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==0){
                union(b,c);
            }
            else{
                if(find(b) != find(c)) bw.write("NO\n");
                else bw.write("YES\n");
            }
        }

        bw.flush();
        bw.close();

    }

    static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x != y){
            map[x] = y;
        }
    }

    static int find(int x) {
        if(map[x] == x) return x;
        else return map[x] = find(map[x]);
    }

}
