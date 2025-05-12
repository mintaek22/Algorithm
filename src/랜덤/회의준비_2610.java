package 랜덤;

import java.io.*;
import java.util.*;

public class 회의준비_2610 {
    /**
     * 아는 사람끼린 같은 위원회
     * 가장 많은 위원회 만들기
     * 대표 정하는 방법은 가장 낮은 높이의 트리 만들기
     */

    static int N,M;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
            arr.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        //그룹 확인
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> leaders = new ArrayList<>();

        for (int i = 1; i < N+1; i++) {
            //해당 그룹을 탐색하지 않았다면
            if(!set.contains(find(i))){
                set.add(find(i));

                int minDepth = Integer.MAX_VALUE;
                int leader = -1;
                //해당 트리 탐색
                for(int j=1;j<N+1;j++){
                    //트리안에 노드
                    if(find(j) == find(i)){
                        dp = new int[N+1];
                        Arrays.fill(dp,-1);
                        int depth = searchDepth(j);
                        if(depth<minDepth){
                            minDepth = depth;
                            leader = j;
                        }
                    }
                }
                leaders.add(leader);
            }
        }

        Collections.sort(leaders);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //그룹 개수
        bw.append(String.valueOf(set.size())).append("\n");

        for (int leader : leaders) {
            bw.append(String.valueOf(leader)).append("\n");
        }

        bw.flush();
    }

    static int searchDepth(int start){
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        q.add(start);
        visited[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : arr.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }

        int maxDist = 0;
        for (int i = 1; i <= N; i++) {
            if (find(i) == find(start)) {
                maxDist = Math.max(maxDist, dist[i]);
            }
        }
        return maxDist;
    }

    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if(parentA != parentB) parent[parentA] = parentB;
    }

    static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
