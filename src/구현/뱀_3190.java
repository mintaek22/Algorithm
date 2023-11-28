package 구현;

import java.io.*;
import java.util.*;

public class 뱀_3190 {

    /**
     * NxN 보드게임
     * 뱀,사과
     * 뱀은 0,0 시작 길이 1 처음엔 오른쪽
     * 머리 앞으로
     * 나가면 끝
     * 사과 O,사과 X,꼬리 move X, len+1
     * 사과 X,꼬리 move
     * **/
    static int N;
    static int K;
    static int L;
    static int[] map;
    static int[] time;
    static int timeIdx = 0;
    static ArrayList<Integer> snake = new ArrayList<>();
    static int nowDir = 1;
    static String[] dir;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N*N];

        snake.add(0);

        //사과 위치
        for (int i = 0; i < K; i++) {
            String[] appleArr = br.readLine().split(" ");

            int x = Integer.parseInt(appleArr[0]);
            int y = Integer.parseInt(appleArr[1]);

            map[(x-1)*N+(y-1)] = 1;
        }

        L = Integer.parseInt(br.readLine());
        time = new int[L];
        dir = new String[L];

        for (int i = 0; i < L; i++) {
            String[] dirArr = br.readLine().split(" ");

            time[i] = Integer.parseInt(dirArr[0]);
            dir[i] = dirArr[1];
        }

        while (true){
            if(!move()){
                break;
            }
        }
        System.out.println(cnt);
    }

    public static boolean move() {

        if(timeIdx < L) {
            if (time[timeIdx] == cnt) {
                if (dir[timeIdx].equals("D")) {
                    if (nowDir != 4) {
                        nowDir++;
                    } else {
                        nowDir = 1;
                    }
                }
                else {
                    if (nowDir != 1) {
                        nowDir--;
                    } else {
                        nowDir = 4;
                    }
                }
                timeIdx++;
            }
        }


        int head;
        if(snake.size() !=0){
            head = snake.get(snake.size() - 1);
        }
        else{
            head = snake.get(0);
        }

        if (nowDir == 1) {
            //머리 이동
            if ((head + 1) % N == 0 || snake.contains(head+1)) {
                cnt ++;
                return false;
            } else {
                snake.add(head + 1);
                head = snake.get(snake.size() - 1);

                //사과 O
                if (map[head] == 1) {
                    map[head] = 0;
                }
                //사과 X
                else {
                    snake.remove(0);
                }
            }
        } else if (nowDir == 2) {
            //머리 이동
            if (head + N >= N * N || snake.contains(head+N)) {
                cnt ++;
                return false;
            } else {
                snake.add(head + N);
                head = snake.get(snake.size() - 1);

                //사과 O
                if (map[head] == 1) {
                    map[head] = 0;
                }
                //사과 X
                else {
                    snake.remove(0);
                }
            }
        } else if (nowDir == 3) {
            //머리 이동
            if (head  % N == 0 || snake.contains(head-1)) {
                cnt ++;
                return false;
            } else {
                snake.add(head - 1);
                head = snake.get(snake.size() - 1);

                //사과 O
                if (map[head] == 1) {
                    map[head] = 0;
                }
                //사과 X
                else {
                    snake.remove(0);
                }
            }
        } else if (nowDir == 4) {
            //머리 이동
            if (head - N < 0 || snake.contains(head-N)) {
                cnt ++;
                return false;
            } else {
                snake.add(head - N);
                head = snake.get(snake.size() - 1);

                //사과 O
                if (map[head] == 1) {
                    map[head] = 0;
                }
                //사과 X
                else {
                    snake.remove(0);
                }
            }
        }
        cnt ++;
        return true;
    }
}
