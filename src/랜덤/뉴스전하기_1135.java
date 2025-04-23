package 랜덤;

import 우선순위큐.문제추천시스템Version1_21939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뉴스전하기_1135 {

    /**
     *  한명의 직속 상사
     *  루트 노드 하나의 트리
     */

    static int[] dp;
    static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            //루트
            if(parent == - 1) continue;

            tree.get(parent).add(i);
        }

        dp = new int[N];
        dp[0] = 0;

        dfs(0);
        System.out.println(dp[0]);

    }

    static void dfs(int parent){

        ArrayList<Integer> children = new ArrayList<>();
        for (int child: tree.get(parent)) {
            dfs(child);
            children.add(dp[child]);
        }
        children.sort(Collections.reverseOrder());

        int max = 0;
        for (int i=0;i<children.size();i++) {
            int new_time = children.get(i) + (i+1);
            max = Math.max(max, new_time);
        }
        dp[parent] = max;

    }


}
