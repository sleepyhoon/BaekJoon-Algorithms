import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visited;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        visited = new boolean[n+1];
        parents = new int[n+1];
        for(int i = 0; i < n+1; i++) {
            arr.add(new ArrayList<>());
            parents[i] = i;
        }

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            arr.get(node1).add(node2);
            arr.get(node2).add(node1);
        }

        bfs();
        for(int i = 2;i<n+1;i++){
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
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
