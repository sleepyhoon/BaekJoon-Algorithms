import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.pow;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        String s = br.readLine();
        long pow = 1;
        for(int i=0;i<n;i++){
            sum += (s.charAt(i)-'a'+1) * pow %1234567891;
            pow = pow * 31 % 1234567891;
        }
        long hash = sum % 1234567891;
        System.out.println(hash);
    }
}