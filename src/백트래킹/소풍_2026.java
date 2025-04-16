package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 소풍_2026 {

    static ArrayList<Integer> ans = new ArrayList<>();
    static boolean[][] map;
    static int K,N,F;
    static ArrayList<Integer> temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        map = new boolean[N+1][N+1];

        for (int i = 0; i < F; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            map[b][a] = true;
        }


        for (int i = 1; i < N+1; i++) {
            temp = new ArrayList<>();
            temp.add(i);
            dfs(i);
            if(!ans.isEmpty()) break;
        }

        if(ans.isEmpty()) System.out.println(-1);
        else{
            for (int num:ans) {
                System.out.println(num);
            }
        }
    }

    static void dfs(int num){
        if(!ans.isEmpty()) return;

        if(temp.size() == K){
            ans = new ArrayList<>(temp);
            return;
        }
        for(int i=num+1;i<N+1;i++){
            if(map[num][i]){
                boolean isMember = true;
                for(int check:temp){
                    if(!map[i][check]){
                        isMember = false;
                        break;
                    }
                }
                if(isMember){
                    temp.add(i);
                    dfs(i);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}
