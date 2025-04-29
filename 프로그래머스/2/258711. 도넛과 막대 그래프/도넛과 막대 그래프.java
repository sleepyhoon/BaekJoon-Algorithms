import java.util.*;

class Solution {
    // 도넛 모양은 모두 in out 1 1
    // 막대 모양은 시작 in 0 끝 out 0
    // 8자 모양은 중심이 in 2 out 2
    // 생성한 정점의 번호, 도넛, 막대, 8자 개수
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> entrance = new ArrayList<>();
    static int[] answer = new int[4];
    static boolean[] visited;
    static int nodeCount = 0; 
    public int[] solution(int[][] edges) {
        for(int i=0;i<edges.length;i++){
            nodeCount = Math.max(nodeCount, Math.max(edges[i][0],edges[i][1]));
        }
        visited = new boolean[nodeCount+1];
        for(int i=0;i<nodeCount+1;i++){
            list.add(new ArrayList<>());
            entrance.add(0);
        }

        for(int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            entrance.set(edge[1], entrance.get(edge[1]) + 1);
        }

        int start = 0;
        for(int i=1;i<list.size();i++){
            if(list.get(i).size() >= 2 && entrance.get(i) == 0) {
                start = i;
            }
        }
        answer[0] = start;
        // 생성 지점을 없다고 생각
        for(int i=0;i<list.get(start).size();i++){
            entrance.set(list.get(start).get(i), entrance.get(list.get(start).get(i))- 1);
        }

        for(int i=0;i<list.get(start).size();i++){
            int tmp = list.get(start).get(i);
            if(!visited[tmp]) {
                boolean find = false;
                Queue<Integer> q = new ArrayDeque<>();
                q.add(tmp);
                while(!q.isEmpty()){
                    int node = q.poll();
                    // 8자 형
                    if(list.get(node).size() == 2 && entrance.get(node) == 2) {
                        answer[3]++;
                        find = true;
                    }
                    // 직선 형
                    else if(list.get(node).isEmpty()) {
                        answer[2]++;
                        find = true;
                    }
                    else {
                        for(int j=0;j<list.get(node).size();j++){
                            if(!visited[list.get(node).get(j)]) {
                                q.add(list.get(node).get(j));
                                visited[list.get(node).get(j)] = true;
                            }
                        }
                    }
                }
                if(!find) {
                    answer[1]++;
                }
            }
        }

    
        return answer;
    }
}