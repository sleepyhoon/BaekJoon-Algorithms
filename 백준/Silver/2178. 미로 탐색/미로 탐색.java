import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int n,m;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {0,0,-1,1}; // 상하좌우
    static int[] dy = {-1,1,0,0}; // 상하좌우
    public static void bfs(int x,int y) {
        visited[y][x] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        while (!q.isEmpty()) {
            int[] list = q.poll();
            int startx = list[0];
            int starty = list[1];
            for (int i = 0; i < 4; i++) {
                int newx = startx + dx[i];
                int newy = starty + dy[i];
                if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                    if (!visited[newy][newx] && map[newy][newx]==1) {
                        q.add(new int[] {newx,newy});
                        visited[newy][newx] = true;
                        dist[newy][newx] = dist[starty][startx] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(dist[n-1][m-1]+1);
    }
    }