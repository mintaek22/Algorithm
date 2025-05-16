package 트리;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 신년파티_1623 {

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[][] dp;
    static boolean[] visited;
    static int[] score;
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1][2];
        visited = new boolean[N+1];
        score = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N+1; i++) tree.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i < N+1; i++) {
            int child = i;
            int parent = Integer.parseInt(st.nextToken());
            tree.get(parent).add(child);
            tree.get(child).add(parent);
        }

        visited[1] = true;
        find(1);

        visited = new boolean[N+1];
        visited[1] = true;
        track(1,true,true);

        visited = new boolean[N+1];
        visited[1] = true;
        track(1,false,false);

        Collections.sort(list);
        Collections.sort(list2);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(String.valueOf(dp[1][1])).append(" ").append(String.valueOf(dp[1][0])).append("\n");

        for(int num:list) bw.append(String.valueOf(num)).append(" ");
        bw.append("-1").append("\n");

        for(int num:list2) bw.append(String.valueOf(num)).append(" ");
        bw.append("-1");

        bw.flush();

    }

    static void find(int num){
        boolean isLeaf = true;

        dp[num][1] = score[num];

        for(int next:tree.get(num)){
            if(!visited[next]){
                visited[next] = true;
                isLeaf = false;
                find(next);

                dp[num][1] += dp[next][0];
                dp[num][0] += Math.max(dp[next][0], dp[next][1]);
            }
        }

        if(isLeaf){
            //불참
            dp[num][0] = 0;

            //참
            dp[num][1] = score[num];
        }
    }

    static void track(int num,boolean isAttend,boolean isRootAttend){
        //참석할 경우
        if(isAttend){
            if(isRootAttend) list.add(num);
            else list2.add(num);

            for(int next:tree.get(num)){
                //모두 불참
                if(!visited[next]){
                    visited[next] = true;
                    track(next,false,isRootAttend);
                }
            }
        }
        //불참일 경우
        else{
            for(int next:tree.get(num)){
                // 불참,참 중 높은거
                if(!visited[next]){
                    visited[next] = true;
                    if(dp[next][1]>dp[next][0]){
                        track(next,true,isRootAttend);
                    }
                    else{
                        track(next,false,isRootAttend);
                    }
                }
            }
        }

    }
}
