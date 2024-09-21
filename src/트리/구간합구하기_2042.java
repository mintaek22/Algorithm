package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기_2042 {

    private static int n,m,k;
    private static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int length = n;
        while (length != 0){
            length/=2;
            treeHeight++;
        }

        int treeSize = (int)Math.pow(2,treeHeight+1);
        int leftNodeStartIndex = treeSize/2 -1;

        tree = new long[treeSize+1];

        for (int i = leftNodeStartIndex+1; i <= leftNodeStartIndex+n; i++) {
             tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize-1);

        for (int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            //변경ㅇ
            if(a == 1){
                updateTree(leftNodeStartIndex+b,c);
            }
            //합구하기
            else{
                b += leftNodeStartIndex;
                c +=leftNodeStartIndex;
                System.out.println(getTree(b,c));
            }
        }

    }

    private static void setTree(int num){
        while (num !=1){
            //부모 노드에 자식노드 값을 채운다
            tree[num/2] += tree[num];
            num--;
        }
    }

    private static void updateTree(long num,long new_num){
        long gap = new_num-tree[(int)num];
        while (num > 0){
            tree[(int)num] += gap;
            num/=2;
        }
    }

    private static long getTree(long start,long end){
        long partSum = 0;
        while (start<=end){
            //홀수(오른쪽)
            if(start % 2 == 1){
                partSum += tree[(int)start];
                start++;
            }
            //짝수(왼쪽)
            if(end%2 == 0){
                partSum += tree[(int)end];
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return partSum;
    }
}
