package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 드래곤커브_15685 {

    static int[][] map = new int[101][101];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            ArrayList<Integer> dir = makeDir(d, g);

            map[y][x] = 1;
            for (Integer integer : dir) {
                y += dy[integer];
                x += dx[integer];
                map[y][x] = 1;
            }
        }

        int ans = countSquare();
        System.out.println(ans);
    }

    static ArrayList<Integer> makeDir(int d,int g){
        ArrayList<Integer> dir = new ArrayList<>();
        dir.add(d);
        for (int i = 0; i < g; i++) {
            List<Integer> newDir = dir.stream()
                    .map(num -> turn(num))
                    .collect(Collectors.toList());

            for (int j = newDir.size()-1; j >= 0; j--) {
                dir.add(newDir.get(j));
            }
        }
        return dir;
    }

    static int turn(int num){
        if(num == 3) return 0;
        else return num+1;
    }

    static int countSquare(){
        int result = 0;
        for (int i = 0; i < map.length-1; i++) {
            for (int j = 0; j < map[0].length-1; j++) {
                if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1){
                    result++;
                }
            }
        }
        return result;
    }
}
