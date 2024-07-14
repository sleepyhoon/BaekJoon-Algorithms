import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int dist;

        public Point(int x, int y,int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            if(this.dist < o.dist)
                return -1;
            else if(this.dist > o.dist)
                return 1;
            return 0;
        }
    }

    static int n,size,min;
    static int[][] map; // 가중치를 확인.
    static int[][] distance; // 각 지점에 가는데 필요한 최소 비용(거리)
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 테스트 횟수만큼 진행하기.
        for(int i=0;i<n;i++){
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            distance = new int[size][size];
            // map 입력받기
            for(int j=0;j<size;j++){
                String input = br.readLine();
                for(int k=0;k<size;k++){
                    map[j][k] = input.charAt(k) - '0';
                }
            }
            dijkstra();
            System.out.println("#"+(i+1)+" "+distance[size-1][size-1]);
        }
    }

    private static void dijkstra() {
        for(int i=0;i<size;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(0, 0, 0));

        while(!q.isEmpty()){
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int dist = p.dist;

            if(distance[x][y] < dist) continue;

            for(int k=0;k<4;k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx<0 || ny<0 || nx>=size || ny>=size) continue;
                if(distance[nx][ny] > dist + map[nx][ny]){
                    distance[nx][ny] = dist + map[nx][ny];
                    q.add(new Point(nx,ny,distance[nx][ny]));
                }
            }
        }
    }
}