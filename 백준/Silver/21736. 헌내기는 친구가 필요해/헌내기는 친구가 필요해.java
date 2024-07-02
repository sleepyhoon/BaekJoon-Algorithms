import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static char[][] map;
    static boolean[][] visited;
    static int N, M;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            map[i] = s.toCharArray();
        }
        int startx = 0;
        int starty = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 'I'){
                    startx = i;
                    starty = j;
                }
            }
        }
        dfs(startx,starty);
        System.out.println(answer > 0 ? answer : "TT");
    }

    private static void dfs(int startx, int starty) {
        visited[startx][starty] = true;
        for(int i=0;i<4;i++){
            int nx = startx + dx[i];
            int ny = starty + dy[i];
            if(nx<0 || nx>= N || ny<0 || ny>= M || map[nx][ny] == 'X') continue;
            else {
                if(map[nx][ny]=='O' && !visited[nx][ny]) {
                    dfs(nx,ny);
                }
                else if(map[nx][ny] == 'P' && !visited[nx][ny]) {
                    answer++;
                    dfs(nx,ny);
                }
            }
        }
    }
}