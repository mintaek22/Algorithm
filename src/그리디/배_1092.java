package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 배_1092 {

    static int N,M;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());


        M = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr,(o1,o2)->o2-o1);
        Collections.sort(box);

        int time = 0;
        while(!box.isEmpty()){
            time++;
            int remainBoxs = box.size();
            int index = box.size() - 1;

            for (int i = 0; i < N; i++) {
                int weight = arr[i];
                while(!box.isEmpty() && index>=0){
                    int big = box.get(index);
                    if(weight >= big){
                        box.remove(index);
                        index--;
                        break;
                    }
                    else index--;
                }
            }

            if(remainBoxs == box.size()){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(time);


    }
}
