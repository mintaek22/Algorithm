package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 링크와스타트_15661 {

    static int N;
    static int[][] S;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        subset(0, new ArrayList<>(), new ArrayList<>());

        System.out.println(minDiff);
    }

    static void subset(int idx, List<Integer> teamA, List<Integer> teamB) {
        if (idx == N) {
            if (teamA.isEmpty() || teamB.isEmpty()) return;
            minDiff = Math.min(minDiff, Math.abs(getScore(teamA) - getScore(teamB)));
            return;
        }

        teamA.add(idx);
        subset(idx + 1, teamA, teamB);
        teamA.remove(teamA.size() - 1);

        teamB.add(idx);
        subset(idx + 1, teamA, teamB);
        teamB.remove(teamB.size() - 1);
    }

    static int getScore(List<Integer> team) {
        int score = 0;
        for (int i = 0; i < team.size(); i++)
            for (int j = i + 1; j < team.size(); j++) {
                int p1 = team.get(i), p2 = team.get(j);
                score += S[p1][p2] + S[p2][p1];
            }
        return score;
    }
}
