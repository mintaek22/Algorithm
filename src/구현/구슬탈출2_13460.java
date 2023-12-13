package 구현;

import java.io.*;
import java.util.*;

public class 구슬탈출2_13460 {


    /**
     * 보드크기 N*M
     * 빨간구슬 빼기
     * 파란구슬 X
     * 4방향 기울이기
     * R,B 둘다 빠져도 실패
     * 10번 이하로 빨간구슬 빼기
     * 횟수 출력 못하면 -1
     */
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int holeX, holeY;
    static int blueX,blueY,redX,redY;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        // 구슬 map 구성
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {

                map[i][j] = str.charAt(j);
                if (map[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                } else if (map[i][j] == 'B') {
                    blueX = i;
                    blueY = j;
                } else if (map[i][j] == 'R') {
                    redX = i;
                    redY = j;
                }
            }
        }

        System.out.println(bfs());

        br.close();
    }

    public static int bfs() {
        Queue<Idx> queue = new LinkedList<>();
        queue.add(new Idx(redX, redY, blueX, blueY, 1));
        visited[redX][redY][blueX][blueY] = true;

        while (!queue.isEmpty()) {
            Idx Idx = queue.poll();

            int curRx = Idx.rx;
            int curRy = Idx.ry;
            int curBx = Idx.bx;
            int curBy = Idx.by;
            int curCnt = Idx.cnt;

            if (curCnt > 10) { // 이동 횟수가 10 초과시 실패
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                while (map[newRx + dx[i]][newRy + dy[i]] != '#') {
                    newRx += dx[i];
                    newRy += dy[i];

                    if (newRx == holeX && newRy == holeY) {
                        isRedHole = true;
                        break;
                    }
                }

                while (map[newBx + dx[i]][newBy + dy[i]] != '#') {
                    newBx += dx[i];
                    newBy += dy[i];

                    if (newBx == holeX && newBy == holeY) {
                        isBlueHole = true;
                        break;
                    }
                }

                if (isBlueHole) {
                    continue;
                }

                if (isRedHole) {
                    return curCnt;
                }

                if (newRx == newBx && newRy == newBy) {
                    if (i == 0) {
                        if (curRx > curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else if (i == 1) {
                        if (curRy < curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    } else if (i == 2) {
                        if (curRx < curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else {
                        if (curRy > curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    }
                }

                if (!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;
                    queue.add(new Idx(newRx, newRy, newBx, newBy, curCnt + 1));
                }
            }
        }

        return -1;
    }
}
class Idx {
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;

        Idx(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
}
