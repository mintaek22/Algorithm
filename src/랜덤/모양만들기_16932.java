package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 모양만들기_16932 {


    static int[][] group,map;
    static int[] dx = new int[] {0,0,1,-1};
    static int[] dy = new int[] {1,-1,0,0};
    static int count;
    static int groupNumber = 0;
    static int N,M;
    static HashMap<Integer,Integer> score = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        group = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1 && group[i][j] == 0){
                    groupNumber++;
                    count = 0;
                    bfs(i,j);
                    score.put(groupNumber,count);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //합치기
                if(map[i][j] == 0){
                    HashSet<Integer> set = new HashSet<>();
                    int sum = 1;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx>=0 && nx<N && ny>=0 && ny<M) {
                            //하나만 추가
                            if (group[nx][ny] > 0 && !set.contains(group[nx][ny])) {
                                set.add(group[nx][ny]);
                                sum += score.get(group[nx][ny]);
                            }
                        }
                    }
                    ans = Math.max(ans,sum);
                }
            }
        }

        System.out.println(ans);


    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        group[x][y] = groupNumber;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            count++;
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1 && group[nx][ny] == 0) {
                    group[nx][ny] = groupNumber;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

}
