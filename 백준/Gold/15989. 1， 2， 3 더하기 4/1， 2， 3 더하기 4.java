import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[10001][4];
        // [][1] = 1로 시작하고 1로만 이루어짐
        // [][2] = 2로 시작하고 1,2로만 이루어짐
        // [][3] = 3로 시작하고 1,2,3로만 이루어짐
        dp[1][1] = 1; dp[1][2] = 0; dp[1][3] = 0;
        dp[2][1] = 1; dp[2][2] = 1; dp[2][3] = 0;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;
        for(int j=4;j<10001;j++){
            dp[j][1] = dp[j-1][1];
            dp[j][2] = dp[j-2][1] + dp[j-2][2];
            dp[j][3] = dp[j-3][1] + dp[j-3][2] + dp[j-3][3];
        }
        for(int i=0;i<n;i++){
            int input = sc.nextInt();
            System.out.println(dp[input][1] + dp[input][2] + dp[input][3]);
        }
    }
}