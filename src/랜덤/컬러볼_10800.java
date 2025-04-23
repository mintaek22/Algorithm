package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 컬러볼_10800 {

    /**
     * 작고 색이 다른 공
     * 공의 크기가 점수
     *
     * 누적합
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //색깔별 무게
        HashMap<Integer, ArrayList<Integer>> allWeightByColor = new HashMap<>();
        HashMap<Integer, int[]> ball = new HashMap<>();
        int[] allWeight = new int[N];
        int[] allPreSum = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            allWeightByColor.computeIfAbsent(color, k -> new ArrayList<>()).add(weight);
            ball.put(i, new int[] {color, weight});
            allWeight[i] = weight;
        }

        //전체에 대한 누적합
        Arrays.sort(allWeight);
        allPreSum[0] = allWeight[0];
        for (int i = 1; i < N; i++) {
            allPreSum[i] = allPreSum[i - 1] + allWeight[i];
        }

        //칼라별 누적합
        HashMap<Integer, int[]> preSum = new HashMap<>();

        //누적합
        for (int color : allWeightByColor.keySet()) {
            Collections.sort(allWeightByColor.get(color));
            int[] preSumArr = new int[allWeightByColor.get(color).size()];

            preSumArr[0] = allWeightByColor.get(color).get(0);
            for(int i=1;i<allWeightByColor.get(color).size();i++){
                preSumArr[i] = allWeightByColor.get(color).get(i) + preSumArr[i-1];
            }

            preSum.put(color, preSumArr);
        }


        for (int i = 0; i < N; i++) {
            //기준 공 번호(i)
            int curColor = ball.get(i)[0];
            int curWeight = ball.get(i)[1];

            int sum = 0;
            //합구하기
            //이진 탐색
            int start = 0;
            int end = allWeight.length - 1;
            int lastIndex = -1;
            while(start<=end){
                int mid = (start+end)/2;
                if(allWeight[mid] < curWeight){
                    start = mid + 1;
                    lastIndex = mid;
                }
                else end = mid - 1;
            }

            //만족하는 공 없음
            if(lastIndex == -1){
                System.out.println(0);
                continue;
            }
            else{
                sum += allPreSum[lastIndex];
            }

            //같은 색깔 제거
            ArrayList<Integer> weights = allWeightByColor.get(curColor);
            //이진 탐색
            start = 0;
            end = weights.size() - 1;
            lastIndex = -1;
            while(start<=end){
                int mid = (start+end)/2;
                if(weights.get(mid) < curWeight){
                    start = mid + 1;
                    lastIndex = mid;
                }
                else end = mid - 1;
            }

            //제거할 무게 있음
            if(lastIndex != -1) {
                sum -= preSum.get(curColor)[lastIndex];
            }

            System.out.println(sum);
        }


    }
}
