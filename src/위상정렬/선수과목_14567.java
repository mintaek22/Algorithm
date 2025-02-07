package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 선수과목_14567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }

        int[] depth = new int[N+1];
        Arrays.fill(depth, 1);
        for (int i = 1; i < N+1; i++) {
            ArrayList<Integer> priorList = list.get(i);
            for (Integer prior : priorList) {
                depth[i] = Math.max(depth[i],  depth[prior] + 1);
            }
        }

        for (int i = 1; i < N+1; i++) {
            System.out.print(depth[i]+" ");
        }
    }
}
