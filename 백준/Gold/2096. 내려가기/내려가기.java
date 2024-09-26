import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());

            if(i==0) {
                maxDp[0] = x1; minDp[0] = x1;
                maxDp[1] = x2; minDp[1] = x2;
                maxDp[2] = x3; minDp[2] = x3;
            } else {
                // 최대값 구하기
                int beforeMaxDp_0 = maxDp[0];
                int beforeMaxDp_2 = maxDp[2];
                maxDp[0] = max(maxDp[0],maxDp[1]) + x1;
                maxDp[2] = max(maxDp[1],maxDp[2]) + x3;
                maxDp[1] = max(max(beforeMaxDp_0,maxDp[1]),beforeMaxDp_2) + x2;

                // 최소값 구하기
                int beforeMinDp_0 = minDp[0];
                int beforeMinDp_2 = minDp[2];
                minDp[0] = min(minDp[0],minDp[1]) + x1;
                minDp[2] = min(minDp[1],minDp[2]) + x3;
                minDp[1] = min(min(beforeMinDp_0,minDp[1]),beforeMinDp_2) + x2;
            }
        }
        System.out.print(max(max(maxDp[0],maxDp[1]),maxDp[2]) + " " + min(min(minDp[0],minDp[1]),minDp[2]));
    }
}