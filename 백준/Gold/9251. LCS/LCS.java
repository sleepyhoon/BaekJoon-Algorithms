import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        int[][] dp = new int [input1.length() + 1][input2.length() + 1];

        for(int i = 0; i < input1.length() + 1; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i < input2.length() + 1; i++){
            dp[0][i] = 0;
        }

        for(int i = 1; i < input1.length() + 1; i++){
            for(int j = 1; j < input2.length() + 1; j++){
                if(input1.charAt(i - 1) == input2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[input1.length()][input2.length()]);
    }
}