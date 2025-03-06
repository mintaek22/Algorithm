package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 도토리숨기기_15732 {

    static int N,K,D;
    static ArrayList<Node> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());


        for (int i = 0; i < K; i++) {
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Node(a,b,c));
        }

        int start = 1;
        int end = N;
        int ans = 0;
        while (start <= end) {
            int mid =(start+end)/2;
            long count = 0;
            for (int i = 0; i < K; i++) {
                Node node = arr.get(i);
                if(mid>=node.x){
                    count += ((Math.min(mid, node.y)- node.x)/ (long)node.gap)+1;
                }
            }
            if(count>=D) {
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        System.out.println(ans);
    }

    static class Node{
        int x;
        int y;
        int gap;

        public Node(int x, int y, int gap) {
            this.x = x;
            this.y = y;
            this.gap = gap;
        }
    }
}
