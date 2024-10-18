
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();
        String answer = "";
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int order = 1;
        int current = 0;
        for(int i=0;i<n;i++){
            current = Integer.parseInt(inputs[i]);
            if(current == order) order++;
            else if(!st.empty() && st.peek() == order) {
                order++;
                st.pop();
                i--;
            }
            else st.push(current);
        }
        while(!st.empty()){
            int output = st.pop();
            if(order == output) {
                order++;
                continue;
            }
            answer = "Sad";
            break;
        }
        if(order-1 == n) {
            answer = "Nice";
        } else
            answer = "Sad";
        System.out.println(answer);
    }
}
