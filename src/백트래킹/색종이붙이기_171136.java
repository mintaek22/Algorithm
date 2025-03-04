package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기_171136 {

    static int[][] map = new int[10][10];
    static boolean[][] visited = new boolean[10][10];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,new int[] {0,0,0,0,0,0});

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void dfs(int index,int[] count){
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += count[i];
        }

        if(sum>=ans) return;

        if(index == 100) {
            ans = sum;
            return;
        }

        int x = index / 10;
        int y = index % 10;
        if(!visited[x][y] && map[x][y] == 1){
            for (int size = 1; size <=5 ; size++) {
                if(count[size]<5 && isPossible(x,y,size)){
                    check(x,y,size);
                    int[] newCount = count.clone();
                    newCount[size]++;
                    dfs(index+size,newCount);
                    unCheck(x,y,size);
                }
            }
        }
        else{
            dfs(index+1, count.clone());
        }
    }

    static boolean isPossible(int x,int y,int size){
        if(x+size-1<10 && y+size-1<10){
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if(map[x+i][y+j] == 0 || visited[x+i][y+j]) return false;
                }
            }
        }
        else return false;

        return true;
    }

    static void check(int x,int y,int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                visited[x+i][y+j] = true;
            }
        }
    }

    static void unCheck(int x,int y,int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                visited[x+i][y+j] = false;
            }
        }
    }
}
