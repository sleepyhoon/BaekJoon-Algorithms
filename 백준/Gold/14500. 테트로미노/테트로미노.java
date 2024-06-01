import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] visited;

    // 상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        arr = new int[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = true;
                dfs(i,j,arr[i][j],1);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    private static void dfs(int x, int y, int sum, int depth) {
        if(depth==4){
            max = Math.max(max,sum);
            return;
        }
        for(int i=0;i<4;i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            // 범위에서 벗어남
            if(newX<0 || newX >= arr.length || newY<0 || newY >= arr[0].length){
                continue;
            }
            // 방문하지 않은 노드
            if(!visited[newX][newY]){
                if(depth==2){
                    visited[newX][newY] = true;
                    dfs(x,y,sum + arr[newX][newY],depth+1);
                    visited[newX][newY] = false;
                }
                visited[newX][newY] = true;
                dfs(newX,newY,sum + arr[newX][newY],depth+1);
                visited[newX][newY] = false;
            }
        }
    }
}