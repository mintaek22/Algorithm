package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 게리맨더링_17471 {
    /**
     * 2개의 선거구
     * 최소 한개 구역 포함
     * 선거구 끼리는 모두 인접
     */

    static int[] people;
    static ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        people = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N+1; i++) edgeList.add(new ArrayList<>());

        for (int i = 1; i < N+1; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 1; j < arr.length; j++) {
                edgeList.get(i).add(arr[j]);
                edgeList.get(arr[j]).add(i);
            }
        }

        boolean[] visited = new boolean[N+1];
        dfs(1,visited);
        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    static void dfs(int index,boolean[] visited){
        if(index == visited.length){
            int aScore = 0;
            int bScore = 0;
            for (int i = 1; i < visited.length; i++) {
                if(visited[i]) aScore += people[i];
                else bScore += people[i];
            }

            //최소 한 구는 있어야 한다
            if(aScore == 0 || bScore == 0) return;

            //차가 적다면 판별 하기
            if(Math.abs(aScore-bScore)<ans){
                ArrayList<Integer> remainATeam = new ArrayList<>();
                ArrayList<Integer> remainBTeam = new ArrayList<>();
                for (int i = 1; i < visited.length; i++) {
                    if(visited[i]) remainATeam.add(i);
                    else remainBTeam.add(i);
                }

                int start = remainATeam.get(0);
                remainATeam.remove(0);
                boolean[] tree_visited = new boolean[visited.length];
                tree_visited[start] = true;
                treeCheck(start, tree_visited, remainATeam);

                if(!remainATeam.isEmpty()) return;

                start = remainBTeam.get(0);
                remainBTeam.remove(0);
                tree_visited = new boolean[visited.length];
                tree_visited[start] = true;
                treeCheck(start, tree_visited, remainBTeam);

                if(remainBTeam.isEmpty()) ans = Math.abs(aScore-bScore);
            }
            return;
        }

        boolean[] new_visited = visited.clone();
        new_visited[index] = true;
        dfs(index+1,new_visited);

        new_visited = visited.clone();
        new_visited[index] = false;
        dfs(index+1,new_visited);
    }

    static void treeCheck(int node,boolean[] visited,ArrayList<Integer> remainNode){
        for(int next : edgeList.get(node)){
            if(!visited[next] && remainNode.contains(next)){
                remainNode.remove((Integer) next);
                visited[next] = true;
                treeCheck(next,visited,remainNode);
            }
        }
    }
}
