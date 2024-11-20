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
        long m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        long[] dp = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        for(int i=1;i<n+1;i++){
            dp[i] = dp[i-1] + arr[i];
        }

        int answer = 0;
        for(int i=1;i<n+1;i++){
            int l = i;
            int r = i;
            while(r<n+1) {
                long sum = dp[r] - dp[l-1];
                if(sum==m)
                    answer++;
                r++;
            }
        }
        System.out.println(answer);
    }
}
