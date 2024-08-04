import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        int[] output = new int[r];

        combination(output,1,0,n,r);
    }

    private static void combination(int[] output, int start, int depth, int n,int r) {
        if(depth == r) {
            for (int i : output) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for(int i=start;i<n+1;i++) {
                output[depth] = i;
                combination(output,i,depth+1,n,r);
            }
        }
    }
}
