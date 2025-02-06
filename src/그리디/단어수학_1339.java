package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 단어수학_1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String,Integer> numInjectionMap = new HashMap<>();

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<s.length();j++){
                int tenNumber  =  s.length()-(j+1);
                String alphabet = String.valueOf(s.charAt(j));
                numInjectionMap.put(alphabet,numInjectionMap.getOrDefault(alphabet,0)+(int)Math.pow(10,tenNumber));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o2.value-o1.value);

        numInjectionMap.forEach((k,v)->{
            pq.add(new Node(k,v));
        });

        int number = 9;
        int ans = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            ans += node.value*number;
            number--;
        }

        System.out.println(ans);
    }
}

class Node{
    String alphabet;
    int value;

    public Node(String alphabet, int value) {
        this.alphabet = alphabet;
        this.value = value;
    }
}
