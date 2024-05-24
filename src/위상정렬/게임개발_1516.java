package 위상정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발_1516 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] time = new int[n+1];
        int[] d = new  int[n+1];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true){
                int before = Integer.parseInt(st.nextToken());
                if(before == -1) break;
                arr.get(before).add(i);
                d[i]++;
            }
        }

        int[] ans = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            if(d[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int before = q.poll();
            ans[before] += time[before];
            for (int next:arr.get(before)) {
                d[next]--;
                ans[next] = Math.max(ans[next],ans[before]);
                if(d[next] == 0) q.add(next);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < n+1; i++) {
            bw.write(ans[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
