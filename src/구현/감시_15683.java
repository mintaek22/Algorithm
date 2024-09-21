package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 감시_15683 {

    static int N,M;
    static ArrayList<Point> pointList = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num>0 && num<6){
                    pointList.add(new Point(i,j,num));
                }
            }
        }

        dfs(map,0);
        System.out.println(ans);
    }

    static void dfs(int[][] map,int depth){

        if(depth == pointList.size()){
            countZero(map);
            return;
        }

        Point point = pointList.get(depth);

        if(point.camera == 1){
            for (int i = 0; i < 4; i++) {
                int[][] newMap = mapClone(map);
                watch(newMap,point,i);
                dfs(newMap,depth+1);
            }
        }
        else if(point.camera == 2){
            int[][] newMap = mapClone(map);
            watch(newMap,point,0);
            watch(newMap,point,1);
            dfs(newMap,depth+1);

            int[][] newMap2 = mapClone(map);
            watch(newMap2,point,2);
            watch(newMap2,point,3);
            dfs(newMap2,depth+1);
        }
        else if(point.camera == 3){
            int[][] newMap = mapClone(map);
            watch(newMap,point,0);
            watch(newMap,point,2);
            dfs(newMap,depth+1);

            int[][] newMap2 = mapClone(map);
            watch(newMap2,point,1);
            watch(newMap2,point,3);
            dfs(newMap2,depth+1);

            int[][] newMap3 = mapClone(map);
            watch(newMap3,point,0);
            watch(newMap3,point,3);
            dfs(newMap3,depth+1);

            int[][] newMap4 = mapClone(map);
            watch(newMap4,point,1);
            watch(newMap4,point,2);
            dfs(newMap4,depth+1);
        }
        else if(point.camera == 4){
            int[][] newMap = mapClone(map);
            watch(newMap,point,0);
            watch(newMap,point,1);
            watch(newMap,point,2);
            dfs(newMap,depth+1);

            int[][] newMap2 = mapClone(map);
            watch(newMap2,point,0);
            watch(newMap2,point,2);
            watch(newMap2,point,3);
            dfs(newMap2,depth+1);

            int[][] newMap3 = mapClone(map);
            watch(newMap3,point,1);
            watch(newMap3,point,2);
            watch(newMap3,point,3);
            dfs(newMap3,depth+1);

            int[][] newMap4 = mapClone(map);
            watch(newMap4,point,0);
            watch(newMap4,point,1);
            watch(newMap4,point,3);
            dfs(newMap4,depth+1);
        }
        else if(point.camera == 5){
            int[][] newMap = mapClone(map);
            watch(newMap,point,0);
            watch(newMap,point,1);
            watch(newMap,point,2);
            watch(newMap,point,3);
            dfs(newMap,depth+1);
        }
    }

    static void countZero(int[][] map){
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) count++;
            }
        }
        ans = Math.min(ans,count);
    }

    static void watch(int[][] map,Point p,int dir){
        int x = p.x+dx[dir];
        int y = p.y+dy[dir];

        while(x>=0 && x<N && y>=0 && y<M && map[x][y]!=6){
            //아무겂도 없으면 포인트로
            if(map[x][y] == 0) map[x][y] = 7;
            x+= dx[dir];
            y+= dy[dir];
        }
    }

    static int[][] mapClone(int[][] map){
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            newMap[i] = map[i].clone();
        }
        return newMap;
    }



    static class Point{
        int x;
        int y;
        int camera;

        public Point(int x, int y, int camera) {
            this.x = x;
            this.y = y;
            this.camera = camera;
        }
    }
}
