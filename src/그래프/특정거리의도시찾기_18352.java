package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기_18352 {

    //방향있는 그래프
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //묶음 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //최단거리
        int K = Integer.parseInt(st.nextToken());
        //출발
        int X = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        Queue<Node> q = new LinkedList<>();
        boolean[] visit = new boolean[N+1];
        HashSet<Integer> set = new HashSet<>();
        visit[X] = true;
        q.add(new Node(X,0));
        //최단 거리
        while (q.size()>0){
            Node node = q.poll();
            int distance  = node.distance;
            if(distance == K){
                break;
            }
            //다음 도시
            ArrayList<Integer> city = arr.get(node.start);
            for (int idx:city) {
                if(!visit[idx]) {
                    visit[idx] = true;
                    q.add(new Node(idx, distance + 1));
                    if (distance + 1 == K) {
                        set.add(idx);
                    }
                }
            }
        }
        if(set.size() == 0){
            System.out.println(-1);
            return;
        }
        ArrayList<Integer> sortedSet = new ArrayList<>(set);
        Collections.sort(sortedSet);
        for (int num:sortedSet) {
            System.out.println(num);
        }
    }
    static class Node{
        int start;
        int distance;
        public Node(int start, int distance) {
            this.start = start;
            this.distance = distance;
        }
    }
}


