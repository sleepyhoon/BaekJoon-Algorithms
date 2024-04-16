import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int gcd(int a,int b) {
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        while(test-->0) {
            // m = 10, n = 12
            int m = sc.nextInt();
            int n = sc.nextInt();
            // x,y = <3,9>
            int x = sc.nextInt();
            int y = sc.nextInt();
            // 나머지를 사용
            // 3 -> 3,m+3,2m+3,,,,,
            // 9 -> 9,n+9,2n+9,,,,,
            // 같은 것이 있으면 출력, 아니면 -1
            int lcm = m*n/gcd(m,n);
            // y의 범위가 1~12 이므로 y--을 시행하면 0~11이 되므로 나머지의 조건을 만족하게 된다.
            // 그리고 나서 나온 year+1을 하면 우리가 원하는 답이다.
            x--;
            y--;
            int year = x;
            while(year<lcm){
                if(year%n==y){
                    System.out.println(year+1);
                    break;
                }
                else {
                    year += m;
                }
            }
            if(year>=lcm)
                System.out.println(-1);
        }
    }
}