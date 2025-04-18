package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 순회강연_2109 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Node> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            arr.add(new Node(pay, day));
        }

        arr.sort((a, b) -> b.pay - a.pay);

        int ans = 0;

        boolean[] visited = new boolean[10001];

        for (int i = 0; i < arr.size(); i++) {
            Node node = arr.get(i);
            int day = node.day;
            while(day>=1 && visited[day]) {
                day--;
            }
            if(day>0) {
                visited[day] = true;
                ans+= node.pay;
            }

        }
        System.out.println(ans);

    }

    static class Node{
        int pay;
        int day;

        public Node(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }
}
