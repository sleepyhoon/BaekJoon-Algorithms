import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        long[] dp = new long[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[i] = 0;
        }
        Arrays.sort(arr);

        dp[0] = arr[0];
        if(arr.length > 1) {
            dp[1] = Math.max(dp[0] + arr[1], arr[0] * arr[1]);
            for(int i = 2; i < n; i++) {
                dp[i] = Math.max(arr[i] + dp[i-1], (arr[i-1] * arr[i]) + dp[i-2]);
            }
        }
        System.out.println(dp[n-1]);
    }
}
