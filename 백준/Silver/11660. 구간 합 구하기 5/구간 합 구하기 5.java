import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int input = Integer.parseInt(st.nextToken());
                sum += input;
                arr[i][j] = input;
                dp[i][j] = sum;
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int fromX = Integer.parseInt(st.nextToken())-1;
            int fromY = Integer.parseInt(st.nextToken())-1;
            int toX = Integer.parseInt(st.nextToken())-1;
            int toY = Integer.parseInt(st.nextToken())-1;

            int bigger = 0;
            int smaller = 0;

            if(fromY ==0){
                for(int j=fromX;j<=toX;j++){
                    bigger += dp[j][toY];
                }
            } else
                for(int j=fromX;j<=toX;j++){
                    bigger += dp[j][toY];
                    smaller += dp[j][fromY-1];
                }
            System.out.println(bigger - smaller);
        }
    }
}