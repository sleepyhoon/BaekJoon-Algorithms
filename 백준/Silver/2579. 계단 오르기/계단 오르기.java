import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();

       int[] stair = new int[n+1];
       int[] sum = new int[n+1];
       for(int i=1;i<=n;i++) {
           stair[i] = sc.nextInt();
       }
       sum[1] = stair[1];
       if(n>1) sum[2] = stair[1] + stair[2];
       for(int i=3;i<=n;i++){
           sum[i] = max(sum[i-2]+stair[i],sum[i-3]+stair[i-1]+stair[i]);
       }
        System.out.println(sum[n]);
    }
}
