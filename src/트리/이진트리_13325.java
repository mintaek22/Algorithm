package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이진트리_13325 {

    static int[] score;
    static int max = 0;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int H = Integer.parseInt(br.readLine());
        score = new int[(int)Math.pow(2,H+1)-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<score.length;i++) score[i] = Integer.parseInt(st.nextToken());

        //길이의 최댓값
        dfs(0,0);

        find(0,0);

        for (int i = 1; i < score.length ; i++) ans += score[i];
        System.out.println(ans);

    }

    static void dfs(int num,int sum){
        //다음 자식 없음
        if(2*num+1 >= score.length) {
            max = Math.max(max,sum);
            return;
        }

        dfs(2*num+1,sum + score[2*num+1]);
        dfs(2*num+2,sum + score[2*num+2]);
    }

    static int find(int num,int sum){

        //리프 노드
        if(2*num+1 >= score.length) {
            //부족한 가중치 반환
            return max-sum;
        }

        int a = find(2*num+1,sum + score[2*num+1]);
        int b= find(2*num+2,sum + score[2*num+2]);

        ans += Math.abs(a-b);
        return Math.min(a,b);
    }

}
