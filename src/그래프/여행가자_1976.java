package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자_1976 {

    static private int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        map = new int[n+1];
        for (int i = 1; i <= n; i++) {
            map[i] = i;
        }
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if(Integer.parseInt(st.nextToken()) == 1){
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int before = Integer.parseInt(st.nextToken());
        boolean ans = true;
        for (int i = 1; i < m; i++) {
            if(find(before) != find(Integer.parseInt(st.nextToken()))) {
                ans = false;
                break;
            }
        }
        if(ans) System.out.println("YES");
        else System.out.println("NO");
    }
    static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x!=y) map[x] = y;
    }

    static int find(int x){
        if(map[x] == x) return x;
        else return map[x] = find(map[x]);
    }


}
