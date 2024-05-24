package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class 버블소트_1377 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Node(i,Integer.parseInt(br.readLine())));
        }

        arr.sort((o1, o2) -> o1.num - o2.num);

        int max = 0;
        for (int i = 0; i < n; i++) {
            int index = arr.get(i).index;
            max = Math.max(max,index-i+1);
        }

        System.out.println(max);
    }
}

class Node{
    int index;
    int num;
    Node(int index,int num){
        this.index = index;
        this.num = num;
    }
}

