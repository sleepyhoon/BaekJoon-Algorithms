import java.util.*;

class Solution {
    static class Node {
        int index;
        int cost;
        Node(int i, int c) {
            index = i;
            cost = c;
        }
    }
    public int solution(int n, int[][] edge) {
        return func(n, edge);
    }
    
    private int func(int n, int[][] e) {
        List<List<Integer>> graph = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<e.length;i++){
            graph.get(e[i][0]).add(e[i][1]);
            graph.get(e[i][1]).add(e[i][0]);
        }
        
        pq.offer(new Node(1,0));

        while(!pq.isEmpty()){
            Node p = pq.poll();
            int index = p.index;
            int cost = p.cost;
            for(int i=0;i<graph.get(index).size();i++){
                int next = graph.get(index).get(i);
                if(dist[next] > cost + 1) {
                    dist[next] = cost + 1;
                    pq.offer(new Node(next, cost + 1));
                }
            }
        }
        
        int max = 0;
        for(int x: dist) {
            if(x==Integer.MAX_VALUE) continue;
            max = Math.max(max,x);
        }
        int answer = 0;
        for(int x: dist) {
            if(x==Integer.MAX_VALUE) continue;
            if(x==max) {
                answer++;
            }
        }
        return answer;
    }
}