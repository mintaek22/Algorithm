package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 문자열제거_21941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());

        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            map.put(a,value);
        }

        int[] dp = new int[s.length()+1];
        for(int index = s.length()-1;index>=0;index--){
            dp[index] = dp[index+1] + 1;
            for(String a : map.keySet()){
                if(s.startsWith(a,index)){
                    dp[index] = Math.max(dp[index],dp[index+a.length()]+map.get(a));
                }
            }
        }

        System.out.println(dp[0]);
    }
}
