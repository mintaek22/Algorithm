package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램_2623 {

    static int[] degree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < N+1; i++) arr.add(new ArrayList<>());

        degree = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count-1; j++) {
                int next =  Integer.parseInt(st.nextToken());
                degree[next]++;
                arr.get(before).add(next);
                before = next;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        ArrayList<Integer> ans = new ArrayList<>();

        //차수가 없다
        for (int i = 1; i < N+1; i++) {
            if(degree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);

            for (int next : arr.get(cur)) {
                degree[next]--;
                if(degree[next] == 0) {
                    q.add(next);
                }
            }
        }

        if(ans.size()<N) System.out.println(0);
        else{
            for(int num:ans){
                System.out.println(num);
            }
        }
    }
}
