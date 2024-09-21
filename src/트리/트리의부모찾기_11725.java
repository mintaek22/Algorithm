package 트리;

import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의부모찾기_11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        boolean[] visit = new boolean[n+1];
        int[] ans = new int[n+1];
        ans[1] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        while (!q.isEmpty()) {
            Integer num = q.poll();
            for (int next:arr.get(num)) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    ans[next] = num;
                }
            }
        }

        for (int i = 2; i < n+1; i++) {
            System.out.println(ans[i]);
        }
    }
}
