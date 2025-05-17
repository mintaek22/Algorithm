package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리디자이너호석_22253 {

    static int[] score;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static long ans =0;
    static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        score = new int[N+1];
        for (int i = 1; i < N+1; i++) score[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+1; i++) tree.add(new ArrayList<>());
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree.get(start).add(end);
            tree.get(end).add(start);
        }

        visited = new boolean[N+1];
        visited[1] = true;
        long[] count = new long[10];
        dfs(1,count);

        System.out.println(ans);

    }

    static void dfs(int num,long[] count){
        long sum = 0;
        for(int i=0;i<=score[num];i++){
            sum += count[i];
        }

        ans += ((sum+1)%MOD);
        ans %= MOD;

        //노드 1개도 추가
        count[score[num]] += (sum + 1) % MOD;
        count[score[num]] %= MOD;

        for(int next:tree.get(num)){
            if(!visited[next]){
                visited[next] = true;
                long[] newCount = count.clone();
                dfs(next,newCount);
            }
        }

    }
}
