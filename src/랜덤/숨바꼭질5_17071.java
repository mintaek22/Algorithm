package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질5_17071 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] goal = new int[500001];
        Arrays.fill(goal,-1);

        int index = K;
        int time = 0;
        while(index<500001){
            goal[index] = time;
            time++;
            index += time;
        }

        boolean[][] visited = new boolean[500001][2];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N,0));
        visited[N][isEven(0)] = true;

        int ans = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Node cur = q.poll();

            //더 이상 없음
            if(cur.time > time) break;

            //만남
            if(goal[cur.index]>=cur.time && isEven(goal[cur.index]) == isEven(cur.time)){
                ans = Math.min(ans,goal[cur.index]);
            }

            //앞으로 이동
            if(cur.index+1<=500000 &&  !visited[cur.index+1][isEven(cur.time+1)]){
                visited[cur.index+1][isEven(cur.time+1)] = true;
                q.add(new Node(cur.index+1,cur.time+1));
            }

            //뒤로 이동
            if(cur.index-1 >= 0 &&  !visited[cur.index-1][isEven(cur.time+1)]){
                visited[cur.index-1][isEven(cur.time+1)] = true;
                q.add(new Node(cur.index-1,cur.time+1));
            }

            //순간 이동
            if(cur.index * 2 <= 500000 &&  !visited[cur.index * 2][isEven(cur.time+1)]){
                visited[cur.index * 2][isEven(cur.time+1)] = true;
                q.add(new Node(cur.index * 2,cur.time+1));
            }
        }

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    static int isEven(int num){
        return num % 2 == 0 ? 1 : 0;
    }

    static class Node{
        int index;
        int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}
