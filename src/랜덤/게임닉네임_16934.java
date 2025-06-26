package 랜덤;

import java.io.*;
import java.util.*;

public class 게임닉네임_16934 {
    public static void main(String[] args) throws IOException {
        Map<String,Integer> nameCount = new HashMap<>();
        Set<String> preFixSet = new HashSet<>();
        ArrayList<String> arr = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String s = br.readLine();

            //이름 카운트 추가
            if(nameCount.containsKey(s)) nameCount.put(s,nameCount.get(s)+1);
            else nameCount.put(s,1);

            boolean isGetAlias = false;
            StringBuilder sb = new StringBuilder();
            int len = s.length();
            for(int j=0;j<len;j++){
                sb.append(s.charAt(j));
                String preFix = sb.toString();

                //해당 접두사 별칭이 없다
                if(!preFixSet.contains(preFix)){
                    //별칭이 아직 없을 경우
                    if(!isGetAlias) arr.add(preFix);
                    preFixSet.add(preFix);
                    isGetAlias = true;
                }
            }

            //별칭을 못 얻음
            if(!isGetAlias){
                int count = nameCount.get(s);
                if(count == 1) arr.add(s);
                else arr.add(s+count);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String s:arr){
            bw.append(s);
            bw.newLine();
        }
        bw.flush();
    }
}
