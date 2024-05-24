package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 회의실배정_1913 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //묶음 개수
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        arr.sort((o1, o2) -> {
            if(o1.end != o2.end){
                return o1.end- o2.end;
            }
            else {
                return o1.start- o2.start;
            }
        });
        int key= arr.get(0).end;
        int ans = 1;
        for (int i = 1; i <n; i++) {
            if(arr.get(i).start>=key){
                key = arr.get(i).end;
                ans++;
            }
        }

        System.out.println(ans);

    }

    static class Node{
        int start;
        int end;
        Node(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
}


