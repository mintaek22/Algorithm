package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 구현_20207 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->{
            if(o1.start == o2.start){
                return o2.len- o1.len;
            }
            return o1.start - o2.start;
        });

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            q.add(new Node(start, end));
        }

        int start = -1;
        int end = -1;

        int ans = 0;

        ArrayList<Integer> arr = new ArrayList<>();

        while (!q.isEmpty()) {
            Node node = q.poll();
            if(end+1<node.start){

                ans += (end-start+1) * arr.size();

                //새로운 코팅지
                arr = new ArrayList<>();

                start = node.start;
                end = node.end;

                arr.add(node.end);
            }
            else{
                boolean next = true;
                for(int i=0;i<arr.size();i++){
                    if(arr.get(i)<node.start){
                        arr.remove(i);
                        arr.add(i,node.end);
                        end = Math.max(end,node.end);
                        next = false;
                        break;
                    }
                }
                if(next){
                    arr.add(arr.size(),node.end);
                    end = Math.max(end,node.end);
                }
            }
        }

        ans += (end-start+1) * arr.size();

        System.out.println(ans);
    }

    static class Node{
        int start;
        int end;
        int len;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.len = end - start;
        }
    }
}