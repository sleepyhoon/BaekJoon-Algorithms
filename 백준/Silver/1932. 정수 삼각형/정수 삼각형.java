import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = matrix[0][0];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(j==0) {
                    dp[i][0] = dp[i-1][0] + matrix[i][0];
                } else if (j==i) {
                    dp[i][j] = dp[i - 1][j - 1] + matrix[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + matrix[i][j];
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dp[n-1][i]);
        }
        System.out.println(max);
    }
}