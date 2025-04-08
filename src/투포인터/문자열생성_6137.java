package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 문자열생성_6137 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] arr = new char[N];
        for (int i = 0; i < N; i++) arr[i] = br.readLine().charAt(0);

        ArrayList<Character> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = N-1;
        while(start<=end){
            if(arr[start]<arr[end]){
                arrayList.add(arr[start++]);
            }
            else if(arr[start]>arr[end]){
                arrayList.add(arr[end--]);
            }
            else{
                int tempStart = start;
                int tempEnd = end;
                while(arr[tempStart]==arr[tempEnd] && tempStart<tempEnd){
                    tempStart++;
                    tempEnd--;
                }
                if(arr[tempStart]<=arr[tempEnd]){
                    arrayList.add(arr[start++]);
                }
                else {
                    arrayList.add(arr[end--]);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if(i != 0 && i%80 == 0) System.out.println();
            System.out.print(arrayList.get(i));
        }
    }
}
