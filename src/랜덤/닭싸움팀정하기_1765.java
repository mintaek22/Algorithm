package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 닭싸움팀정하기_1765 {

    /**
     * 친구끼리는 같은 팀
     */

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i < N+1; i++) parent[i] = i;

        ArrayList<ArrayList<Integer>> FList = new ArrayList<>();
        for (int i = 0; i < N+1; i++) FList.add(new ArrayList<>());

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            //친구
            if(a.equals("F")){
                union(p,q);
            }
            //원수
            else{
                FList.get(p).add(q);
                FList.get(q).add(p);
            }
        }

        //원수를 통해 친구 찾기
        for (int i = 1; i < FList.size(); i++) {
            if(FList.get(i).size() >=2){
                int flag = FList.get(i).get(0);
                for (int j = 1; j <FList.get(i).size() ; j++) {
                    union(flag,FList.get(i).get(j));
                }
            }
        }

        HashSet<Integer> teams = new HashSet<>();
        for (int i = 1; i < N+1; i++) {
            teams.add(find(i));
        }
        System.out.println(teams.size());
    }

    static void union(int a,int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA != parentB) parent[parentA] = parentB;
    }

    static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
}
