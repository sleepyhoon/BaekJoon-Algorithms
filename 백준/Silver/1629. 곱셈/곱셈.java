import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        System.out.println(calculate(A, B, C));
    }

    private static long calculate(long a, long b, long c) {
        if(b==0)
            return 1;
        long n = calculate(a,b/2,c);
        if(b%2==0)
            return n*n%c;
        else
            return (n%c*n%c)*a%c;
    }
}