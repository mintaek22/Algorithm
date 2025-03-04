package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 죽음의비_22944 {

    static int N,H,D;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = new int[] {0,0,1,-1};
    static int[] dy = new int[] {1,-1,0,0};
    static int startX,startY;
    static int goalX,goalY;
    static int hp;
    static int umbrella = 0;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        hp = H;

        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S'){
                    startX = i;
                    startY = j;
                }
                else if(map[i][j] == 'E'){
                    goalX = i;
                    goalY = j;
                }
            }
        }
        visited[startX][startY] = true;
        dfs(startX,startY,0);

        System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
    }

    static void dfs(int x,int y,int step){
        if(step>=ans) return;

        if(map[x][y] != 'S'){
            //끝
            if(map[x][y] == 'E') {
                ans = step;
                return;
            }
            umbrella = D-1;
        }

        int cur_hp =hp;
        int cur_umbrella = umbrella;

        ArrayList<Node> nodeList = getNextNode(x,y,hp+umbrella);
        for(Node node : nodeList){
            visited[node.x][node.y] = true;

            if(umbrella<node.step-1){
               hp = hp - (node.step-1) + umbrella;
            }

            dfs(node.x, node.y, step+node.step);

            visited[node.x][node.y] = false;
            hp = cur_hp;
            umbrella = cur_umbrella;
        }
    }

    static ArrayList<Node> getNextNode(int x, int y, int maxStep){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,0));

        ArrayList<Node> result = new ArrayList<>();

        boolean[][] q_visited = new boolean[N][N];
        q_visited[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            if(node.step > maxStep) break;

            if(map[node.x][node.y] == 'U' || map[node.x][node.y] == 'E'){
                if(!visited[node.x][node.y]) result.add(new Node(node.x,node.y,node.step));
            }

            if(map[node.x][node.y] == 'E') break;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N){
                    if(!q_visited[nx][ny]){
                        q_visited[nx][ny] = true;
                        q.add(new Node(nx,ny,node.step+1));
                    }
                }
            }
        }

        return result;
    }
    static class Node{
        int x;
        int y;
        int step;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}
