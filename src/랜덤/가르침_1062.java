package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침_1062 {
    /**
     * a,n,t,i,c. 5개는 최소
     */

    static int K,N;
    static int[] word;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        word = new int[N];

        for (int i = 0; i < N; i++) {
            int cur = 1<<26;
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                cur = cur | 1<<((int)str.charAt(j) - 97);
            }
            word[i] = cur;
        }

        if(K<5){
            System.out.println(0);
            return;
        }

        int alphabet = 1<<26;
        alphabet = alphabet | 1<<((int)'a'-97);
        alphabet = alphabet | 1<<((int)'n'-97);
        alphabet = alphabet | 1<<((int)'t'-97);
        alphabet = alphabet | 1<<((int)'i'-97);
        alphabet = alphabet | 1<<((int)'c'-97);

        K -= 5;

        dfs(0,0,alphabet);

        System.out.println(ans);

    }

    static void dfs(int depth,int end,int alphabet){
        if(depth==K) {
            int count = 0;

            loop:
            for(int i=0;i<N;i++){
                for (int j = 0; j < 26; j++) {
                    if((word[i] & 1<<j) !=0 && (alphabet & 1<<j) == 0) continue loop;
                }
                count++;
            }

            ans = Math.max(ans,count);
            return;
        }



        for (int i = end; i < 26; i++) {
            if((alphabet & 1<<i) == 0){
                dfs(depth+1,i,alphabet | 1<<i);
            }
        }
    }
}
