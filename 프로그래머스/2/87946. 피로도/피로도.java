class Solution {
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        dfs(k,dungeons, 0, new boolean[dungeons.length]);
        return answer;
    }
    
    private static void dfs(int tired, int[][] dungeons, int count, boolean[] visited) {
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && tired >= dungeons[i][0]) {
                visited[i] = true;
                dfs(tired - dungeons[i][1], dungeons, count + 1, visited);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
}