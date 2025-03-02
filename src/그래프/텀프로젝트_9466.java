package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 텀프로젝트_9466 {

    static int[] arr;
    static int ans;
    static boolean[] visited;
    static ArrayList<Integer> visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            ans = 0;
            arr = new int[N+1];
            visited = new boolean[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i < N+1; i++) {
                if(!visited[i]){
                    visit = new ArrayList<>();
                    dfs(i);
                }
            }
            System.out.println(ans);
        }
    }

    static void dfs(int num){
        if(visited[num]){
            for(int node:visit){
                if(node == num) return;
                else ans++;
            }
        }
        else {
            visit.add(num);
            visited[num] = true;
            dfs(arr[num]);
        }
    }
}
