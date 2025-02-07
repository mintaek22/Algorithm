package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제집_1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }

        int[] depth = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            depth[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < N+1; i++) {
            if(depth[i] == 0) pq.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int question = pq.poll();
            ans.add(question);
            ArrayList<Integer> dependencyQuestionList =  list.get(question);
            for (Integer dependQuestion : dependencyQuestionList) {
                depth[dependQuestion]--;
                if(depth[dependQuestion] == 0) pq.add(dependQuestion);
            }
        }

        for(Integer question : ans){
            System.out.print(question+" ");
        }
    }
}
