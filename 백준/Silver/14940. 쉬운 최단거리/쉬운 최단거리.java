import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] cost;
    static boolean[][] visited;

    // 목표 지점의 row,col 알아야함.
    static int startRow = 0;
    static int startCol = 0;

    // 상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        cost = new int[n][m];
        visited = new boolean[n][m];

        // map에 정수 입력
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    startRow = i;
                    startCol = j;
                }
            }
        }
        cost[startRow][startCol] = 0;
        calculateCost(startRow,startCol,0);

        // 갈 수 있는데 길이 없는 곳의 경우 -1로 처리해야 한다.
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==startRow && j==startCol){
                    continue;
                }
                if(cost[i][j]==0 && map[i][j]==1){
                    cost[i][j] = -1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(cost[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void calculateCost(int row, int col,int depth){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        visited[row][col] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int newRow = cur[0]+dx[i];
                int newCol = cur[1]+dy[i];

                // map에서 벗어나는 범위 또는 이미 방문한 경우.
                if(newRow<0 || newRow >= map.length || newCol <0 || newCol >= map[0].length){
                    continue;
                }
                // 갈 수 없는 땅인 경우
                if(map[newRow][newCol]==0){
                    cost[newRow][newCol] = 0;
                    continue;
                }

                // 갈 수 있고 방문한 적이 없는 경우
                if(map[newRow][newCol]==1 && !visited[newRow][newCol]){
                    q.add(new int[]{newRow,newCol});
                    cost[newRow][newCol] = cost[cur[0]][cur[1]] + 1;
                    visited[newRow][newCol] = true;
                }
            }
        }
    }
}