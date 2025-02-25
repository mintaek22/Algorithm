package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 양팔저울_2629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] visited = new boolean[40001];
        visited[0] = true;
        for (int i = 0; i < N; i++) {
            int weight = Integer.parseInt(st.nextToken());
            ArrayList<Integer> visit = new ArrayList<>();
            for (int j = 40000; j >=0 ; j--) {
                if(visited[j]){
                    int in = j+weight;
                    int out = Math.abs(j-weight);
                    if(in<=40000 && !visited[in]) visit.add(in);
                    if(out<=40000 && !visited[out])  visit.add(out);
                }
            }
            for (int vi: visit) visited[vi] = true;
        }


        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int weight = Integer.parseInt(st.nextToken());
            if(visited[weight]) System.out.print("Y ");
            else System.out.print("N ");
        }
    }
}
