package 위상정렬;

import java.io.*;
import java.util.*;

public class 줄세우기_2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int[] d  = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            d[b]++;
        }


        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if(d[i] == 0) {
                q.add(i);
                ans.add(i);
            }
        }

        while (!q.isEmpty()) {
            int person = q.poll();
            for (int next:arr.get(person)) {
                if(d[next]>1) {
                    d[next]--;
                }
                else {
                    q.add(next);
                    ans.add(next);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int person:ans) {
            bw.write(person+" ");
        }
        bw.flush();
        bw.close();
    }

}
