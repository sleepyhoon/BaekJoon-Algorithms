import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] subject = new int[k+1][2];

        // 해당 공부 시간에 해당하는 최대 중요도
        int[][] dp = new int[n+1][k+1];

        for(int i = 1; i < k+1; i++) {
            // 중요도 | 공부 시간
            st = new StringTokenizer(br.readLine());
            subject[i][0] = Integer.parseInt(st.nextToken());
            subject[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<k+1;i++){
            int value = subject[i][0];
            int weight = subject[i][1];
            for(int j=1;j<n+1;j++) {
                if(j >= weight) dp[j][i] = max(dp[j][i-1], value + dp[j-weight][i-1]);
                else dp[j][i] = dp[j][i-1];
            }
        }
        
        System.out.println(dp[n][k]);
    }
}