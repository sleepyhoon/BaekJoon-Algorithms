import java.util.*;

public class Main {
    static Map<Integer,Integer> map;
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visited;
    static int[] parents;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new HashMap<>();
        arr = new ArrayList<>();
        visited = new boolean[n+1];
        parents = new int[n+1];
        for(int i = 0; i < n+1; i++) {
            arr.add(new ArrayList<>());
            parents[i] = i;
        }

        for(int i = 0; i < n-1; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            arr.get(node1).add(node2);
            arr.get(node2).add(node1);
        }

        bfs();
        for(int i = 2;i<n+1;i++){
            System.out.println(parents[i]);
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()) {
            int node = q.poll();
            visited[node] = true;
            for(int input : arr.get(node)) {
                if(!visited[input]) {
                    q.add(input);
                    visited[input] = true;
                    parents[input] = node;
                }
            }
        }
    }


}
