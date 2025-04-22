package 랜덤;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cubeditor_1701 {

    /**
     * 부분 문자열이 2번이상 나와야한다
     * 겹쳐도 된다
     *
     * 2번이상 나오는 가장 긴 부분문자열의 길이를 구하시오
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int start = 0;
        int end = 1;

        int ans = 0;

        while(end<= line.length() && start<end){
            String sub = line.substring(start,end);
            //2개 확인
            boolean isPossible = false;
            int index;
            if((index = line.indexOf(sub))>=0){
                if(line.substring(index + 1).contains(sub)){
                    ans = end-start;
                    isPossible = true;
                }
            }

            if(isPossible) end++;
            else{
                start++;
                end++;
            }
        }

        System.out.println(ans);
    }
}
