package 트리;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MinmaxTree_28472 {

    static ArrayList<ArrayList<Integer>> tree =new ArrayList<>();
    static boolean[] visited;
    static int[] score;
    static int R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+1; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree.get(start).add(end);
            tree.get(end).add(start);
        }
        
        score = new int[N+1];
        
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            score[k] = t;
        }

        visited = new boolean[N+1];
        visited[R] = true;
        //Max Player 로 시작
        dfs(R,true);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            bw.append(String.valueOf(score[q])).append("\n");
        }

        bw.flush();
    }

    static void dfs(int num,boolean isMax){
        //리프 노드일 경우 리턴
        if(num != R && tree.get(num).size()==1) return;

        //초기값
        score[num] = -1;

        for (int next:tree.get(num)) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next,!isMax);

                //초기값
                if(score[num]==-1) score[num]=score[next];
                else{
                    if(isMax) score[num]=Math.max(score[num],score[next]);
                    else score[num]=Math.min(score[num],score[next]);
                }
            }
        }

    }
}
