package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
다리 방향 일정
다리의 길이 2이상
 */
public class 다리만들기2_17472 {

    private static boolean[][] visit;
    private static int[][] map;
    private static int[] arr;
    private static int n,m;
    private static int cnt=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && map[i][j]!=0) bfs(i,j);
                visit[i][j] = true;
            }
        }


        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

        //가로 확인
        for (int i = 0; i < n; i++) {
            int num = -1;
            int zero_cnt = 0;
            for (int j = 0; j < m; j++) {
                if(map[i][j] != 0){
                    if(map[i][j] != num){
                        if(num != -1){
                            if(zero_cnt>1) {
                                pq.add(new Edge(map[i][j],num,zero_cnt));
                            }
                        }
                    }
                    zero_cnt = 0;
                    num = map[i][j];
                }
                else if(map[i][j] == 0) zero_cnt++;
            }
        }

        //세로 확인
        for (int i = 0; i < m; i++) {
            int num = -1;
            int zero_cnt = 0;
            for (int j = 0; j < n; j++) {
                if(map[j][i] != 0){
                    if(map[j][i] != num){
                        if(num != -1){
                            if(zero_cnt>1) {
                                pq.add(new Edge(map[j][i],num,zero_cnt));
                            }
                        }
                    }
                    zero_cnt = 0;
                    num = map[j][i];
                }
                else zero_cnt++;
            }
        }

        //유니온 파인드 배열
        arr = new int[cnt];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int ans = 0;
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            if(find(edge.start) == find(edge.end)) continue;
            union(edge.start,edge.end);
            ans += edge.weight;
        }

        int key = find(1);
        for (int i = 2; i <cnt ; i++) {
            if(key != find(i)){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(ans);

    }

    static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a!=b) arr[a] = b;
    }

    static int find(int a){
        if(arr[a] == a) return a;
        else return arr[a] = find(arr[a]);
    }

    static private class Edge{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static void bfs(int a,int b) {

        Queue<int[]> q = new LinkedList<>();

        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0, 0, 1, -1};
        q.add(new int[]{a, b});
        visit[a][b] = true;
        map[a][b] = cnt;

        while (!q.isEmpty()) {
            int[] list = q.poll();
            for (int i = 0; i < 4; i++) {
                int new_x = list[0]+dx[i];
                int new_y = list[1]+dy[i];
                if(new_x>=0 && new_x<n && new_y>=0 && new_y<m){
                    if (!visit[new_x][new_y]){
                        visit[new_x][new_y] = true;
                        if(map[new_x][new_y] != 0){
                            map[new_x][new_y] = cnt;
                            q.add(new int[]{new_x, new_y});
                        }
                    }
                }
            }
        }
        cnt++;
    }
}
