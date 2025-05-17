package 트리;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 트리의독립집합_2213 {

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] scores;
    static int[][] dp;
    static boolean[] visited;
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        scores = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) scores[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) tree.add(new ArrayList<>());
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree.get(start).add(end);
            tree.get(end).add(start);
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1);

        visited = new boolean[N + 1];
        visited[0] = true;
        tree.get(0).add(1);
        tracking(0,false);

        Collections.sort(ans);
        System.out.println(Math.max(dp[1][0],dp[1][1]));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int num:ans){
            bw.append(String.valueOf(num)).append(" ");
        }
        bw.flush();
    }

    static void dfs(int num){

        //리프노드
        if(num != 1 && tree.get(num).size() == 1){
            dp[num][0] = 0;
            dp[num][1] = scores[num];
            return;
        }

        dp[num][1] = scores[num];

        for(int next:tree.get(num)){
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
                dp[num][1] += dp[next][0];
                dp[num][0] += Math.max(dp[next][1],dp[next][0]);
            }
        }
    }

    static void tracking(int num,boolean isOn){
        for(int next : tree.get(num)){
            if(!visited[next]){
                visited[next] = true;

                //현재가 꺼져 있고 자식은 키는게 더 크다
                if(!isOn && dp[next][1] > dp[next][0]){
                    ans.add(next);
                    tracking(next,true);
                }
                else tracking(next,false);
            }
        }
    }
}

