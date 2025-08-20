package 랜덤;

import java.io.*;
import java.util.*;

public class 독특한계산기_19591 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String str;
    static Deque<Long> num;
    static Deque<Character> cmd;
    static long ans;
    static void parse() throws IOException {
        ans=0;
        st = new StringTokenizer(in.readLine());
        str = st.nextToken();
        num = new LinkedList<>();
        cmd = new LinkedList<>();
        String str_int = "";

        int fir_idx = 0;
        if (str.charAt(0) == '-') {
            str_int += '-';
            fir_idx++;
        }
        boolean flag = false;
        for (int i = fir_idx; i < str.length(); i++) {
            char k = str.charAt(i);
            if (k == '*' || k == '/' || k == '+' || k == '-') {
                if(flag) {
                    num.add(Long.valueOf(str_int));
                }else {
                    num.add(Long.valueOf("0"));
                }
                str_int = "";
                cmd.add(k);
                flag = false;
            } else {
                if(k!='0') {//맨 앞에 0이 나오는 경우
                    flag = true;
                }
                if(flag)
                    str_int += k;
            }
        }
        if (!str_int.equals("-") && !str_int.equals("")) {
            num.add(Long.valueOf(str_int));
        }else
            num.add(Long.valueOf("0"));
    }

    static void check() {
        while (cmd.size() > 1) {
            char pre_cmd = cmd.getFirst();
            char last_cmd = cmd.getLast();
            long pre_num = num.removeFirst();
            long last_num = num.removeLast();
            long preSec_num = num.getFirst();
            long lastSec_num = num.getLast();
            if ((pre_cmd == '*' || pre_cmd == '/') && (last_cmd == '+' || last_cmd == '-')) {
                // 앞 선택
                select_first(last_num, calc(pre_num, preSec_num, pre_cmd));
            } else if ((pre_cmd == '+' || pre_cmd == '-') && (last_cmd == '*' || last_cmd == '/')) {
                // 뒤 선택
                select_last(pre_num, calc(lastSec_num, last_num, last_cmd));
            } else {
                // 크기 비교
                long pre_res = calc(pre_num, preSec_num, pre_cmd);
                long last_res = calc(lastSec_num, last_num, last_cmd);
                if(pre_res > last_res) {
                    select_first(last_num, calc(pre_num, preSec_num, pre_cmd));
                }else if(pre_res < last_res) {
                    select_last(pre_num, calc(lastSec_num, last_num, last_cmd));
                }else {
                    //앞 선택
                    select_first(last_num, calc(pre_num, preSec_num, pre_cmd));
                }
            }
        }

        if(cmd.size()==1) {
            ans = calc(num.removeFirst(), num.removeFirst(), cmd.removeFirst());
        }else {
            ans = num.removeFirst();
        }
    }
    static long calc(long a, long b, char c) {
        if(c=='*') {
            return a*b;
        }else if(c=='/') {
            return a/b;
        }else if(c=='+') {
            return a+b;
        }else  {
            return a-b;
        }
    }
    static void select_first(long last_num, long res) {
        num.addLast(last_num);//맨 뒤 숫자
        num.removeFirst();//맨 앞 숫자
        num.addFirst(res);
        cmd.removeFirst();//맨 앞 연산자
    }
    static void select_last(long pre_num, long res) {
        num.addFirst(pre_num);//맨 앞 숫자
        num.removeLast();//맨 뒤 숫자
        num.addLast(res);
        cmd.removeLast();//맨 뒤 연산자
    }
    public static void main(String[] args) throws IOException {
        parse();// 파싱
        check();// 우선순위 탐색
        System.out.println(ans);
    }
}