import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            min1 = Math.min(min1,Integer.parseInt(st.nextToken()));
            min2 = Math.min(min2,Integer.parseInt(st.nextToken()));
        }

        int tmp = Math.min(min1,n%6*min2);

        int answer = Math.min(n/6 * min1 + tmp, min2 * n);
        System.out.println(answer);
    }
}
