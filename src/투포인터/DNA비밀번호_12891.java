package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호_12891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //DNA 문자열 길이
        int s = Integer.parseInt(st.nextToken());
        //부분 문자열 길이
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String[] dna = st.nextToken().split("");
        //A C G T
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int ca = 0;
        int cc = 0;
        int cg = 0;
        int ct = 0;

        for(int i=0;i<p;i++){
            if (dna[i].equals("A")) {
                ca++;
            } else if (dna[i].equals("C")) {
                cc++;
            } else if (dna[i].equals("G")) {
                cg++;
            } else {
                ct++;
            }
        }
        int answer = 0;

        if(check(a,c, g, t, ca, cc, cg, ct)){
            answer++;
        }
        for (int i = p; i < dna.length; i++) {
            if (dna[i].equals("A")) {
                ca++;
            } else if (dna[i].equals("C")) {
                cc++;
            } else if (dna[i].equals("G")) {
                cg++;
            } else {
                ct++;
            }

            if (dna[i-p].equals("A")) {
                ca--;
            } else if (dna[i-p].equals("C")) {
                cc--;
            } else if (dna[i-p].equals("G")) {
                cg--;
            } else {
                ct--;
            }

            if (check(a, c, g, t, ca, cc, cg, ct)) {
                answer++;
            }
        }

        System.out.println(answer);

    }

    static boolean check(int a,int c,int g,int t,int ca,int cc,int cg,int ct){
        return c <= cc && a <= ca && g <= cg && t <= ct;
    }
}
