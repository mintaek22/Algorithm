package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 암벽등반_2412 {

    static int N,T;
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        T= Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (map.containsKey(y)) {
                map.get(y).add(x);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(x);
                map.put(y, list);
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,0));

        while (!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            if(node.y == T){
                System.out.println(node.distance);
                return;
            }
            for (int i = 2; i>=-2 ; i--) {
                int ny = y+i;
                if(ny>=0){
                    if(map.containsKey(ny)){
                        ArrayList<Integer> nList = new ArrayList<>(map.get(ny));
                        for(Integer nx:map.get(ny)){
                            if(Math.abs(nx-x)<=2){
                                q.add(new Node(nx,ny,node.distance+1));
                                nList.remove((Integer) nx);
                            }
                        }
                        map.put(ny,nList);
                    }
                }
            }
        }

        System.out.println(-1);

    }

    static class Node{
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
