class Solution {
    static long[] dp;
    public long solution(int n) {
        long answer = 0;
        dp = new long[n+1];
        dp[0] = 1;
        dp[2] = 3;
        dp[4] = 11;
        
        if(n < 5) {
            answer = dp[n];
        }
        else {
            for(int i=6;i<=n;i+=2) {
                dp[i] = sum(i-2);
            }
            answer = dp[n];
        }
        
        return answer;
    }
    
    private static long sum(int limit) {
        long sum = 0;
        for(int i=0;i<=limit;i+=2) {
            if(i == limit) {
                sum += dp[i] * 3;
            } else {
                sum += dp[i] * 2;
            }
        }
        return (sum)%1000000007;
    }
}