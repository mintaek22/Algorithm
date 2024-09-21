package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이공사팔_12100 {

    static int N,ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());

        int[][] map=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        ans=0;
        dfs(map,0);
        System.out.println(ans);
    }

    static void dfs(int[][] map,int cnt){
        if(cnt==5){
            ans=Math.max(ans,max(map));
        }
        else{
            int[][] tmp1=new int[N][N];
            int[][] tmp2=new int[N][N];
            int[][] tmp3=new int[N][N];
            int[][] tmp4=new int[N][N];
            for(int i=0;i<N;i++){
                System.arraycopy(map[i],0,tmp1[i],0,map[i].length);
                System.arraycopy(map[i],0,tmp2[i],0,map[i].length);
                System.arraycopy(map[i],0,tmp3[i],0,map[i].length);
                System.arraycopy(map[i],0,tmp4[i],0,map[i].length);
            }

            up(tmp1);
            down(tmp2);
            right(tmp3);
            left(tmp4);

            dfs(tmp1,cnt+1);
            dfs(tmp2,cnt+1);
            dfs(tmp3,cnt+1);
            dfs(tmp4,cnt+1);

        }
    }

    static void up(int[][] map){
        for(int i=0;i<N-1;i++){
            for(int j=0;j<N;j++){
                int a=1;
                while (i+a<=N-1){
                    if(map[i+a][j]==0) a++;
                    else if(map[i][j]==map[i+a][j]){
                        map[i][j]=2*map[i][j];
                        map[i+a][j]=0;
                        break;
                    }
                    else break;
                }
            }
        }
        for(int i=1;i<N;i++) {
            for (int j = 0; j < N; j++) {
                int a=i;
                while (a>=1){
                    if(map[a-1][j]==0){
                        map[a-1][j]=map[a][j];
                        map[a][j]=0;
                        a--;
                    }
                    else break;
                }
            }
        }
    }

    static void down(int[][] map){
        for(int i=N-1;i>0;i--){
            for(int j=0;j<N;j++){
                int a=1;
                while (i-a>=0){
                    if(map[i-a][j]==0) a++;
                    else if(map[i][j]==map[i-a][j]){
                        map[i][j]=2*map[i][j];
                        map[i-a][j]=0;
                        break;
                    }
                    else break;
                }
            }
        }
        for(int i=N-1;i>=0;i--) {
            for (int j = 0; j < N; j++) {
                int a = i;
                while (a + 1 <= N-1) {
                    if (map[a + 1][j] == 0) {
                        map[a + 1][j] = map[a][j];
                        map[a][j] = 0;
                        a++;
                    } else break;
                }
            }
        }
    }

    static void right(int[][] map){
        for (int j = N - 1; j > 0; j--) {
            for (int i = 0; i < N; i++) {
                int a=1;
                while (j-a>=0){
                    if(map[i][j-a]==0) a++;
                    else if(map[i][j]==map[i][j-a]){
                        map[i][j]=2*map[i][j];
                        map[i][j-a]=0;
                        break;
                    }
                    else break;
                }
            }
        }
        for (int j = N-1; j >=0; j--) {
            for (int i = 0; i < N; i++) {
                int a = j;
                while (a + 1 <= N-1) {
                    if (map[i][a+1] == 0) {
                        map[i][a+1] = map[i][a];
                        map[i][a] = 0;
                        a++;
                    } else break;
                }
            }
        }
    }

    static void left(int[][] map){
        for(int j=0;j<N-1;j++){
            for(int i=0;i<N;i++){
                int a=1;
                while (j+a<=N-1){
                    if(map[i][j+a]==0) a++;
                    else if(map[i][j]==map[i][j+a]){
                        map[i][j]=2*map[i][j];
                        map[i][j+a]=0;
                        break;
                    }
                    else break;
                }
            }
        }
        for(int j=1;j<=N-1;j++) {
            for (int i = 0; i < N; i++) {
                int a=j;
                while (a>=1){
                    if(map[i][a-1]==0){
                        map[i][a-1]=map[i][a];
                        map[i][a]=0;
                        a--;
                    }
                    else break;
                }
            }
        }
    }

    static int max(int[][] map){
        int max=ans;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                max=Math.max(max,map[i][j]);
            }
        }
        return max;
    }
}