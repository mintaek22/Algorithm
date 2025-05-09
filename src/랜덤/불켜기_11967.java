package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class 불켜기_11967 {
    /**
     * 나중에 갈 수 도 있다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,ArrayList<Node>> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            String key = x+":"+y;

            if(map.containsKey(key)){
                map.get(key).add(new Node(a,b));
            }
            else{
                map.put(key,new ArrayList<>());
                map.get(key).add(new Node(a,b));
            }
        }

        boolean[][] isMove = new boolean[N+1][N+1];
        boolean[][] isLight = new boolean[N+1][N+1];
        boolean[][] isVisited = new boolean[N+1][N+1];
        isLight[1][1] = true;
        isMove[1][1] = true;
        isVisited[1][1] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1,1));

        int[] dx = new int[] {0,0,-1,1};
        int[] dy = new int[] {1,-1,0,0};

        while(!q.isEmpty()){
            Node cur = q.poll();

            //들어갈 수 있는 node
            for (int i = 0; i < 4; i++) {
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                if(nx>0 && nx<=N && ny>0 && ny<=N){
                    //이동 가능
                    isMove[nx][ny] = true;
                    if(isLight[nx][ny] && !isVisited[nx][ny]){
                        isVisited[nx][ny] = true;
                        q.add(new Node(nx,ny));
                    }
                }
            }

            //불키기
            if(map.containsKey(cur.x+":"+cur.y)){
                for(Node next:map.get(cur.x+":"+cur.y)){
                    isLight[next.x][next.y] = true;
                    if(isMove[next.x][next.y] && !isVisited[next.x][next.y]){
                        isVisited[next.x][next.y] = true;
                        q.add(new Node(next.x,next.y));
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(isLight[i][j]) ans++;
            }
        }

        System.out.println(ans);

    }

    static class Node{
        int x;
        int y;

        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
