package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기_2146 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int[][] group = new int[N][N];
        int groupNumber = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = new int[] {1,-1,0,0};
        int[] dy = new int[] {0,0,1,-1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //섬인데 그룹이 없으면
                if(map[i][j] == 1 && group[i][j] == 0){
                    groupNumber++;
                    Queue<Node> q = new LinkedList<>();
                    q.add(new Node(i, j));
                    group[i][j] = groupNumber;

                    while (!q.isEmpty()){
                        Node node = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = node.x + dx[k];
                            int ny = node.y + dy[k];
                            if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] == 1 && group[nx][ny] == 0){
                                group[nx][ny] = groupNumber;
                                q.add(new Node(nx, ny));
                            }
                        }
                    }
                }
            }
        }


        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0){
                    //주변에 섬이 있다.
                    boolean isNearbyIsland = false;
                    int startIsland = -1;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx>=0 && nx<N && ny>=0 && ny<N && group[nx][ny] != 0){
                            isNearbyIsland = true;
                            startIsland = group[nx][ny];
                            break;
                        }
                    }

                    if(isNearbyIsland){
                        Queue<Node> q = new LinkedList<>();
                        q.add(new Node(i, j,1));

                        boolean[][] visited = new boolean[N][N];
                        visited[i][j] = true;

                        while (!q.isEmpty()){
                            Node node = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = node.x + dx[k];
                                int ny = node.y + dy[k];
                                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]){
                                    visited[nx][ny] = true;

                                    //다른 섬 찾음
                                    if(group[nx][ny]>0 && group[nx][ny]!=startIsland){
                                        ans = Math.min(ans,node.distance);
                                        break;
                                    }

                                    q.add(new Node(nx, ny, node.distance+1));
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static class Node{
        int x;
        int y;
        int distance;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
