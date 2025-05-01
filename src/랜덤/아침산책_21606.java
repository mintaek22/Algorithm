package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 아침산책_21606 {
    /**
     * 트리 구조
     * 처음과 끝은 실내
     * 중간엔 실내가 있으면 안됨
     */

    static boolean[] isInside;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int ans = 0;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        isInside = new boolean[N + 1];

        String[] line = br.readLine().split("");
        for (int i = 0; i < N; i++) {
            isInside[i+1] = line[i].equals("1");
        }

        for (int i = 0; i < N+1; i++) arr.add(new ArrayList<>());

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.get(start).add(end);
            arr.get(end).add(start);
        }


        //중간에 실외를 기준으로 찾는다
        visited = new boolean[N+1];
        for (int i = 1; i < N+1; i++) {
            if(!isInside[i] && !visited[i]){
                cnt = 0;
                dfs(i);
                ans += cnt * (cnt-1);
            }
        }

        //실내 두개 연결
        for (int i = 1; i < N+1; i++) {
            if(isInside[i]) {
                for (int next : arr.get(i)) {
                    if(isInside[next]) ans++;
                }
            }
        }

        System.out.println(ans);

    }

    static void dfs(int num){
        visited[num] = true;
        for (int next: arr.get(num)) {
            if(!isInside[next] && !visited[next]) dfs(next);
            if(isInside[next]) cnt++;
        }
    }
}
