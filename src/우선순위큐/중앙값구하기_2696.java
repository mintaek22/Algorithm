package 우선순위큐;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 중앙값구하기_2696 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int mid = 0;
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1,o2)->o2-o1);
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            ArrayList<Integer> ans = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i < n+1; i++) {
                if((i != 1 && (i-1) % 10 == 0)) st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                if(i==1){
                    mid = num;
                    ans.add(num);
                    continue;
                }
                if(mid>=num) maxQueue.add(num);
                else minQueue.add(num);

                if(i%2 == 1){
                    if(maxQueue.size()>minQueue.size()){
                        minQueue.add(mid);
                        mid = maxQueue.poll();
                    }
                    else if(maxQueue.size()<minQueue.size()){
                        maxQueue.add(mid);
                        mid = minQueue.poll();
                    }
                    ans.add(mid);
                }

            }

            bw.write(String.valueOf(ans.size()));
            bw.newLine();

            for (int i = 0; i < ans.size(); i++) {
                if(i!= 0 && i % 10 == 0)  bw.newLine();
                bw.write(ans.get(i)+" ");
            }
            bw.newLine();
        }

        bw.flush();

    }
}
