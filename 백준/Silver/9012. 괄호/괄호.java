import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            Stack<Character> st = new Stack<>();
            String s = br.readLine();
            for(int j=0;j<s.length();j++){
                char ch = s.charAt(j);
                if(ch=='(')
                    st.push(ch);
                // 다 안 끝났는데 스택이 비어버린 경우
                else if (st.isEmpty()) {
                    st.push(ch); // NO를 출력하기 위해 스택에 원소 하나를 채워줌.
                    break;
                }
                else
                    st.pop();
            }
						// 스택을 비어있다면 YES
            if(st.isEmpty()) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}