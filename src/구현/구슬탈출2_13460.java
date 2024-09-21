package 구현;

import java.io.*;
import java.util.*;

public class 구슬탈출2_13460 {

    static String[][] map;
    static int N,M;
    static int Bx,By,Rx,Ry,Gx,Gy;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = String.valueOf(str.charAt(j));

                if(map[i][j].equals("R")){
                    Rx = i;
                    Ry = j;
                }
                else if(map[i][j].equals("B")){
                    Bx = i;
                    By = j;
                }
                else if(map[i][j].equals("O")){
                    Gx = i;
                    Gy = j;
                }
            }
        }
        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(Bx,By,Rx,Ry,0));

        while (!q.isEmpty()) {
            Position p = q.poll();
            for (int i = 0; i < 4; i++) {

                int newRx = p.rx;
                int newRy = p.ry;
                int newBx = p.bx;
                int newBy = p.by;

                if(p.count>=10) return -1;

                boolean redGoal = false;
                boolean blueGoal = false;

                while(!map[newRx + dx[i]][newRy + dy[i]].equals("#")){
                    newRx += dx[i];
                    newRy += dy[i];
                    if(newRx == Gx && newRy == Gy) redGoal = true;
                }

                while(!map[newBx + dx[i]][newBy + dy[i]].equals("#")){
                    newBx += dx[i];
                    newBy += dy[i];
                    if(newBx == Gx && newBy == Gy) blueGoal = true;
                }

                if(blueGoal) continue;

                if(redGoal) return p.count+1;

                //겹치면
                if(newRx == newBx && newRy == newBy){
                    if(i==0){
                        if(p.ry>p.by) newRy++;
                        else newBy++;
                    }
                    else if(i==1){
                        if(p.ry>p.by) newBy--;
                        else newRy--;
                    }
                    else if(i==2){
                        if(p.rx>p.bx) newRx++;
                        else newBx++;
                    }
                    else{
                        if(p.rx>p.bx) newBx--;
                        else newRx--;
                    }
                }


                if(newRx == p.rx && newRy == p.ry && newBx == p.bx && newBy == p.by) continue;

                q.add(new Position(newBx,newBy,newRx,newRy,p.count+1));
            }
        }
        return -1;
    }

    static class Position{
        int bx;
        int by;
        int rx;
        int ry;
        int count;
        public Position(int bx, int by, int rx, int ry,int count) {
            this.bx = bx;
            this.by = by;
            this.rx = rx;
            this.ry = ry;
            this.count = count;
        }
    }

}
