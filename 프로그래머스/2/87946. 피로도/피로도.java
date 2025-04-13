import java.util.*;

class Solution {
    static int answer;
    public int solution(int k, int[][] dungeons) {
        int length = dungeons.length;
        permutation(k, new int[length], length, 0, new boolean[length], dungeons);
        return answer;
    }
    
    private static void permutation(int k, int[] tmp, int length, int index, boolean[] visited, int[][] dungeons) {
        if(index == length) {
            int count = 0;
            for(int x : tmp) {
                if(k >= dungeons[x][0]) {
                    k -= dungeons[x][1];
                    count++;
                } 
            }
            answer = Math.max(answer, count);
        } else {
            for(int i=0;i<dungeons.length;i++){
                if(!visited[i]) {
                    tmp[index] = i;
                    visited[i] = true;
                    permutation(k,tmp,length,index+1,visited,dungeons);
                    visited[i] = false;
                }
            }
        }
    }
}