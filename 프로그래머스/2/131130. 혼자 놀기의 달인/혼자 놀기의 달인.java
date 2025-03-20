import java.util.*;

class Solution {
    static int[] parents;
    static int[] heights;
    public int solution(int[] cards) {
        int answer = 0;
        int length = cards.length;
        parents = new int[length+1];
        heights = new int[length+1];
        Arrays.fill(parents,-1);
        Arrays.fill(heights,0);
        boolean[] visited = new boolean[length+1];
        for(int card : cards) {
            traverse(visited, card, cards);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<length+1;i++){
            if(parents[i] < 0)
                list.add(parents[i]);
        }
        if(list.size() == 1) {
            answer = 0;
        } else {
            Collections.sort(list);
            answer = list.get(0) * list.get(1);
        }
        return answer;
    }
    
    private static void traverse(boolean[] visited, int start, int[] cards) {
        if(visited[start]) 
            return;
        visited[start] = true;
        union(start,cards[start-1]);
        traverse(visited,cards[start-1],cards);
    }
    
    private static int findParent(int x) {
        if(parents[x] < 0) {
            return x;
        }
        return parents[x] = findParent(parents[x]);
    }
    
    private static void union(int a,int b) {
        int pa = findParent(a);
        int pb = findParent(b);
        
        if(pa == pb) {
            return;
        }
        
        if(heights[pa] < heights[pb]) {
            int tmp = pa;
            pa = pb;
            pb = tmp;
        }
        
        if(heights[pa] == heights[pb]) {
            heights[pa]++;
        }
        heights[pb] = 0;
        parents[pa] += parents[pb];
        parents[pb] = pa;
    }

}