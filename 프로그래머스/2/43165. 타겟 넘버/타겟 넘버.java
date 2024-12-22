class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers,target,0,0);
        return answer;
    }
    
    static int dfs(int[] numbers, int target, int n, int sum) {
        if(n == numbers.length) {
            if(sum == target) 
                return 1;
            return 0;
        }
        else {
            return dfs(numbers,target,n+1,sum + numbers[n]) + dfs(numbers,target,n+1,sum - numbers[n]);
        }
    }
}