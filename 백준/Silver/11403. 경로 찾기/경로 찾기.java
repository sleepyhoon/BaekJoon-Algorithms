import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int[] visited;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            visited = new int[n];
            dfs(i);
            for (int b : visited) {
                sb.append(b).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int start) {
        for(int i = 0; i < n; i++){
            if(visited[i] == 0 && matrix[start][i] == 1){
                visited[i] = 1;
                dfs(i);
            }
        }
    }
}