import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] graph;
    static int vertex,edge,start;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new int[vertex+1][vertex+1];
        check = new boolean[vertex+1];

        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(start);
        sb.append("\n");
        check = new boolean[vertex+1];
        bfs(start);
        System.out.println(sb);
    }

    public static void dfs(int start){
        check[start] = true;
        sb.append(start).append(" ");

        for(int i=0;i<=vertex;i++){
            if(graph[start][i]==1 && !check[i])
                dfs(i);
        }
    }

    public static void bfs(int start){
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()){
            start = q.poll();
            sb.append(start).append(" ");

            for(int i=0;i<=vertex;i++){
                if(graph[start][i]==1 && !check[i]){
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}