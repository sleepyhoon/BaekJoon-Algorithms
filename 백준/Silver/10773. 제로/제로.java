import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        // 문제 수행하기
        for(int i=0;i<n;i++) {
            int input = sc.nextInt();
            if(input==0)
                st.pop();
            else
                st.push(input);
        }
        // 합 구하기
        int sum = 0;
        for (Integer i : st) {
            sum+=i;
        }
        System.out.println(sum);
    }
}