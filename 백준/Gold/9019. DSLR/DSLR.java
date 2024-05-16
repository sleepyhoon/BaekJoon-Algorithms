import java.io.IOException;
import java.util.*;

class Calculator {
    int from;
    String command;

    public Calculator(int from, String command) {
        this.from = from;
        this.command = command;
    }

    int D() {
        return 2*from%10000;
    }

    int S() {
        return from == 0 ? 9999 : from-1;
    }

    int L() {
        return from % 1000 * 10 + from/1000;
    }

    int R() {
        return from % 10 * 1000 + from/10;
    }
}
public class Main {
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-->0){
            int from = sc.nextInt();
            int to = sc.nextInt();
            visit = new boolean[10000];
            visit[from] = true;
            Queue<Calculator> q = new LinkedList<>();
            q.add(new Calculator(from, ""));
            while(!q.isEmpty()){
                Calculator cal = q.poll();
                if(cal.from == to) {
                    sb.append(cal.command).append("\n");
                    break;
                }
                if(!visit[cal.D()]){
                    q.add(new Calculator(cal.D(), cal.command+"D"));
                    visit[cal.D()] = true;
                }
                if(!visit[cal.S()]){
                    q.add(new Calculator(cal.S(), cal.command+"S"));
                    visit[cal.S()] = true;
                }
                if(!visit[cal.L()]){
                    q.add(new Calculator(cal.L(), cal.command+"L"));
                    visit[cal.L()] = true;
                }
                if(!visit[cal.R()]){
                    q.add(new Calculator(cal.R(), cal.command+"R"));
                    visit[cal.R()] = true;
                }
            }
        }
        System.out.println(sb);
    }


}