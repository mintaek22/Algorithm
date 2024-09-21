package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 경사로_14890 {

    static int N,L,ans;
    static int[][] map;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        arr = new int[2*N][N];

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            arr[i] = map[i];
        }

        for (int i=N;i<2*N;i++){
            for (int j = 0; j < N; j++) {
                arr[i][j] = map[j][i-N];
            }
        }

        for (int i = 0; i < 2*N; i++) {
            if(check(arr[i])) ans++;
        }

        System.out.println(ans);
    }

    static boolean check(int[] arr){


        int length = 0;
        int number = 0;
        for (int i = 0; i < arr.length; i++) {

            if(number==0){
                number = arr[i];
                length = 1;
                continue;
            }

            //이어짐
            if(arr[i] == number){
                length++;
            }

            //달라짐
            else{
                //올라감
                if(number+1 == arr[i]){
                    if(length<L) return false;
                    length = 1;
                    number = arr[i];
                }
                else if(number-1 == arr[i]){

                    //둘 곳 없음
                    if(i+L>arr.length) return false;

                    //내리막길 둘 수 있나
                    for (int j = i; j < i+L; j++) {
                        if(arr[j] != arr[i]) return false;
                    }

                    //내리막길 두고 초기화
                    length = 0;
                    i = i+L-1;
                    number = arr[i];

                }
                else return false;
            }
        }
        return true;
    }

}
