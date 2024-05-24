package 그래프;

import java.io.*;
import java.util.*;

public class 효율적인해킹_1325 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //컴퓨터 개수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
        }

        int[] ans = new int[N+1];

        for (int i = 1; i < N+1 ; i++) {
            boolean[] visit = new boolean[N+1];
            Queue<Integer> q = new LinkedList<>();
            visit[i] = true;
            q.add(i);
            while (q.size()>0){
                int next = q.poll();
                for (int num:arr.get(next)) {
                    if(!visit[num]){
                        visit[num] = true;
                        q.add(num);
                        ans[num]++;
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ansScore = 0;
        for (Integer num : ans) {
            ansScore = Math.max(ansScore,num);
        }
        for (int i = 1; i < N + 1; i++) {
            if(ans[i] == ansScore) bw.write(i+" ");
        }
        bw.flush();
        bw.close();
    }
}
