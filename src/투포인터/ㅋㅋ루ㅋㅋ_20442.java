package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ㅋㅋ루ㅋㅋ_20442 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int RCount = 0;
        for (int i = 0; i < str.length(); i++) if (str.charAt(i) == 'R') RCount++;

        int start = 0;
        int end = str.length()-1;

        int ans = RCount;
        int leftKCount = 0;
        int rightKCount = 0;
        while(start <= end){
            if(RCount != 0){
                int score = RCount + Math.min(leftKCount, rightKCount) * 2;
                ans = Math.max(ans, score);
            }
            if(str.charAt(start) == 'K' && str.charAt(end) == 'K'){
                start++;
                end--;
                leftKCount++;
                rightKCount++;
            }
            else if(str.charAt(start) == 'K'){
                start++;
                leftKCount++;
            }
            else if(str.charAt(end) == 'K'){
                end--;
                rightKCount++;
            }
            else{
                if(rightKCount >= leftKCount) start++;
                else end--;
                RCount--;
            }
        }

        System.out.println(ans);
    }
}
