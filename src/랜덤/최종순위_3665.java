package 랜덤;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최종순위_3665 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        loop:
        while(T-->0){
            int N = Integer.parseInt(br.readLine());

            int[] degree = new int[N+1];
            int[] rank = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for (int i = 0; i < N+1; i++) arr.add(new ArrayList<>());

            for (int i = 0; i < N-1; i++) {
                for(int j = i+1; j < N; j++){
                    arr.get(rank[i]).add(rank[j]);
                    degree[rank[j]]++;
                }
            }

            int M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                //반대로 엮여있다.
                if (arr.get(end).contains(start)) {
                    arr.get(end).remove((Integer) start);
                    degree[start]--;
                    arr.get(start).add(end);
                    degree[end]++;
                }
                // 기존에 start → end 였다면 → 이것도 반대로
                else if (arr.get(start).contains(end)) {
                    arr.get(start).remove((Integer) end);
                    degree[end]--;
                    arr.get(end).add(start);
                    degree[start]++;
                }
            }

            ArrayList<Integer> ans = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < N+1; i++) {
                if(degree[i] == 0){
                    q.add(i);
                }
            }

            while(!q.isEmpty()){
                if (q.size() > 1) {
                    bw.append("?").append("\n");
                    continue loop;
                }

                int cur = q.poll();
                ans.add(cur);

                for (int next: arr.get(cur)) {
                    degree[next]--;
                    if(degree[next] == 0){
                        q.add(next);
                    }
                }

            }

            if(ans.size() != N){
                bw.append("IMPOSSIBLE").append("\n");
                continue;
            }

            for (int node:ans) {
                bw.append(String.valueOf(node)).append(" ");
            }

            bw.append("\n");
        }

        bw.flush();
    }

}
