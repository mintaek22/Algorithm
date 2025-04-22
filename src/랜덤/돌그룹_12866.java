package 랜덤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 돌그룹_12866 {
    /**
     * 돌의 개수를 같게 만드는 것이 목적
     * 1.크기가 같지 않은 그룹 2개 선정
     * 2.작은 그룹은 2배 큰 그룹은 gap 만큼
     */

    static HashSet<String> visited = new HashSet<>();
    static boolean isSuccess = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sum = a + b + c;
        if (sum % 3 != 0) {
            System.out.println("0");
            return;
        }

        dfs(new int[]{a, b, c});
        System.out.println(isSuccess ? "1" : "0");
    }

    static void dfs(int[] stones) {
        Arrays.sort(stones);
        int a = stones[0], b = stones[1], c = stones[2];

        String key = a + ":" + b + ":" + c;
        if (visited.contains(key)) return;
        visited.add(key);

        if (a == b && b == c) {
            isSuccess = true;
            return;
        }

        moveAndRecurse(a, b, c);
        moveAndRecurse(a, c, b);
        moveAndRecurse(b, c, a);
    }

    static void moveAndRecurse(int x, int y, int z) {
        if (x == y) return;

        int small = Math.min(x, y);
        int large = Math.max(x, y);

        int[] next = new int[]{small + small, large - small, z};
        dfs(next);
    }
}
