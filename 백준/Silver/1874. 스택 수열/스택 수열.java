import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int start = 0; // 내가 어느 숫자까지 대입해둔 것인지 알기 위해 선언

        for(int i=0;i<n;i++){
            int value = Integer.parseInt(br.readLine());

            if (value > start){ // 스택에 숫자를 대입 해줘야하는 경우
                for(int j=start+1;j<=value;j++){
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                start = value;
            }
            else if (stack.peek() != value){ // 스택 맨 위의 숫자가 input과 다른 경우
                System.out.println("NO");
                return;
            }
            stack.pop(); // 반드시 pop을 해줘야함.
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}