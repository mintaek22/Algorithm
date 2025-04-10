package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class 니가싫어_20440 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> nodeList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(start,true));
            nodeList.add(new Node(end,false));
        }

        nodeList.sort((a,b)->{
            if(a.time == b.time){
                return Boolean.compare(a.isIn, b.isIn);
            }
            return a.time- b.time;
        });

        int curCount = 0;
        int maxCount = 0;

        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();

        for (Node node : nodeList) {
            if (node.isIn) {
                curCount++;
                maxCount = Math.max(maxCount,curCount);
                map.put(node.time,curCount);
            } else {
                curCount--;
                map.put(node.time,curCount);
            }
        }

        int answerStart = -1;
        int answerEnd = -1;

        for (int key : map.keySet()) {
            if(answerStart != -1 && map.get(key) != maxCount){
                answerEnd = key;
                break;
            }
            if(answerStart == -1 && map.get(key)==maxCount){
                answerStart = key;
            }
        }

        System.out.println(maxCount);
        System.out.println(answerStart+" "+answerEnd);

    }
}

class Node{
    int time;
    boolean isIn;

    public Node(int time, boolean isIn) {
        this.time = time;
        this.isIn = isIn;
    }
}