package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 할로윈의양아치_20303 {
    
    static int[] candy,parent;
    static HashMap<Integer,Node> count=new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        candy = new int[N+1];
        parent = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }
        
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        for (int i = 1; i < N+1; i++) {
            int parent = find(i);
            if(count.get(parent)==null){
                count.put(parent,new Node(1,candy[i]));
            }
            else{
                Node node =count.get(parent);
                node.cnt++;
                node.candyCnt+= candy[i];
            }
        }
        
        int[] dp = new int[K];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int parent:count.keySet()){
            Node node = count.get(parent);
            for (int i = K-1;i>=0;i--) {
                if(i-node.cnt>=0 && dp[i- node.cnt] != -1) dp[i] = Math.max(dp[i],dp[i-node.cnt]+node.candyCnt);
            }
        }

        long ans = 0;
        for(int i=1;i<K;i++){
            ans = Math.max(ans,dp[i]);
        }
       System.out.println(ans);
    }

    static void union(int a,int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA!=parentB) parent[parentA]=parentB;
    }

    static int find(int a){
        if(parent[a]==a) return a;
        else return parent[a]=find(parent[a]);
    }

   static class Node{
        int cnt;
        int candyCnt;

       public Node(int cnt, int candyCnt) {
           this.cnt = cnt;
           this.candyCnt = candyCnt;
       }
   }
}
