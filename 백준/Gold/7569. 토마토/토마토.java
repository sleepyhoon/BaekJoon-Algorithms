import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Tomato {
    int height;
    int row;
    int col;

    public Tomato(int height,int row,int col) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}
public class Main {
    static int[][][] box; // 토마토를 담아둘 상자이다.
    // 상 하 좌 우 고 저
    static int[] rowArr = {-1,1,0,0,0,0};
    static int[] colArr = {0,0,-1,1,0,0};
    static int[] heightArr = {0,0,0,0,1,-1};

    static int m;
    static int n;
    static int h;
    static Queue<Tomato> q = new LinkedList<>();

    // 무엇이 x,y,z인지 정확히 인지해야 한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 가로길이
        n = Integer.parseInt(st.nextToken()); // 세로길이
        h = Integer.parseInt(st.nextToken()); // 높이
        box = new int[h][n][m]; // 순서대로 높이,행,열의 개수이다.

        for(int k=0;k<h;k++){
            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                for(int i=0;i<m;i++){
                    box[k][j][i] = Integer.parseInt(st.nextToken());
                    if(box[k][j][i]==1)
                        q.add(new Tomato(k,j,i));
                }
            }
        }
        int answer = bfs();
        System.out.println(answer);
    }

    private static int bfs() {
        while(!q.isEmpty()){
            Tomato tomato = q.poll();
            int height = tomato.height;
            int row = tomato.row;
            int col = tomato.col;

            for(int i=0;i<6;i++) {
                int newHeight = height + heightArr[i];
                int newRow = row + rowArr[i];
                int newCol = col + colArr[i];
                if(checkPoint(newHeight,newRow,newCol)) {
                    q.add(new Tomato(newHeight,newRow,newCol));
                    box[newHeight][newRow][newCol] = box[height][row][col] + 1;
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for(int k=0;k<h;k++){
            for(int j=0;j<n;j++){
                for(int i=0;i<m;i++){
                    if(box[k][j][i]==0)
                        return -1;
                    result = Math.max(box[k][j][i],result);
                }
            }
        }
        if(result==1) return 0;
        else return (result-1);
    }

    private static boolean checkPoint(int height, int row, int col) {
        if(height>=0 && row>=0 && col>=0 && height < h && row < n && col < m) {
            if(box[height][row][col]==0)
                return true;
        }
        return false;
    }
}