import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(startX,startY,direction);
        System.out.println(answer);
    }

    private static void dfs(int x,int y,int direction) {
        if(arr[x][y] == 0) {
            arr[x][y] = 2;
            answer++;
        }

        boolean find = false;
        for(int i=0;i<4;i++) {
            if(x+dx[i]>0&&x+dx[i]<n&&y+dy[i]>0&&y+dy[i]<m){
                // 청소할 곳을 찾음 => 반시계로 90도 회전 후 전진
                if (arr[x + dx[i]][y + dy[i]] == 0) {
                    find = true;
                    break;
                }
            }
        }

        if(find) {
            int direction2 = changeDirection(direction);
            if(arr[x+dx[direction2]][y+dy[direction2]] == 0)
                dfs(x+dx[direction2],y+dy[direction2],direction2);
            else
                dfs(x,y,direction2);
        }
        else {
            if(arr[x-dx[direction]][y-dy[direction]] != 1)
                dfs(x-dx[direction],y-dy[direction],direction);
        }
    }

    private static int changeDirection(int direction) {
        if (direction == 0)
            return 3;
        else
            return direction - 1;
    }
}
