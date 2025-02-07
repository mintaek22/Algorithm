package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 애너그램_6443 {

    static ArrayList<String> tmp;
    static StringBuilder answer = new StringBuilder();
    static boolean[] visited;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            arr = br.readLine().split("");
            Arrays.sort(arr);
            visited = new boolean[arr.length];
            tmp = new ArrayList<>();
            dfs(0);
        }
        System.out.print(answer);
    }
    public static void dfs(int depth){
        if(depth == arr.length){
            StringBuilder str = new StringBuilder();
            for(String s: tmp){
                str.append(s);
            }
            answer.append(str).append("\n");
        }
        else{
            String lastUsed = "";
            for (int i = 0; i < arr.length; i++) {
                if(!visited[i] && !lastUsed.equals(arr[i])){
                    visited[i] = true;
                    tmp.add(arr[i]);
                    lastUsed = arr[i];
                    dfs(depth+1);
                    visited[i] = false;
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
}
