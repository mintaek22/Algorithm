package 투포인터;

import java.io.*;
import java.util.*;

public class 최솟값찾기_11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            //현재 값이 더 작으면
            while (!deque.isEmpty() && num<deque.peekLast().num){
                deque.pollLast();
            }

            deque.addLast(new Node(i,num));

            if(!deque.isEmpty() &&  deque.peekFirst().index == i-l){
                deque.pollFirst();
            }

            bw.write(deque.getFirst().num+" ");
        }
        bw.flush();
    }
    static class Node{
        int index;
        int num;
        Node(int index,int num){
            this.index = index;
            this.num = num;
        }
    }
}

