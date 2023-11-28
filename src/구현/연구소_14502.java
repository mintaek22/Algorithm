package 구현;

import java.io.*;
import java.util.*;

public class 연구소_14502 {

    static int[][] map;
    static int N;
    static int M;
    static ArrayList<Integer> arr2 = new ArrayList<>();
    static int[] dx = new int[] {1,-1,0,0};
    static int[] dy = new int[] {0,0,1,-1};
    static int[][] newMap;

    static int ans = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        newMap = new int[N][M];

        int start = 0;
        boolean visit = false;
        for (int i = 0; i < N; i++) {

            String[] arr = br.readLine().split(" ");

            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(arr[j]);
                if(map[i][j] == 0 && !visit){
                    start = i*j+j;
                    visit = true;
                }

                if(map[i][j] == 2){
                    arr2.add(i*M+j);
                }

            }
        }
        createWall(0,start);

        System.out.println(ans);

    }

    public static void createWall(int depth,int start){
        if(depth == 3){
            score();
            return;
        }

        for(int i = start; i < N*M; i++){
            if(map[i/M][i%M] == 0){
                map[i/M][i%M] = 1;
                createWall(depth+1,i+1);
                map[i/M][i%M] = 0;
            }
        }
    }

    public static void score(){
        int score = 0;
        for (int i = 0; i < N; i++) {
            newMap[i] = map[i].clone();
        }

        for (int n : arr2) {
            DFS(n);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(newMap[i][j] == 0){
                    score ++;
                }
            }
        }

        ans = Math.max(ans,score);


    }

    public static void DFS(int n){
        for (int i = 0; i < 4; i++) {
            int x = n/M+dx[i];
            int y = n%M+dy[i];
            if(0<=x && x<N && 0<=y && y<M) {
                if(newMap[x][y] == 0){
                    newMap[x][y] = 2;
                    DFS(x*M+y);
                }
            }
        }

    }
}