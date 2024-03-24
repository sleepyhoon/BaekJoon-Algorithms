import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
        int sum = 0;
        boolean start = true;
        while (minus.hasMoreTokens()) {
            int tmp = 0;
            StringTokenizer plus = new StringTokenizer(minus.nextToken(),"+");
            while(plus.hasMoreTokens()){
                tmp += Integer.parseInt(plus.nextToken());
            }
            if (start) {
                sum = tmp;
                start = false;
            }
            else sum-=tmp;
        }
        System.out.println(sum);
    }
}