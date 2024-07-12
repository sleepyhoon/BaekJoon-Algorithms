/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n,size,min;
    static int[][] map; // 가중치를 확인.
    static boolean[][] visited; // 방문 여부를 확인.
    static int[][] cost; // 각 지점
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 테스트 횟수만큼 진행하기.
        for(int i=0;i<n;i++){
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            cost = new int[size][size];
            visited = new boolean[size][size];
            // map 입력받기
            for(int j=0;j<size;j++){
                String input = br.readLine();
                for(int k=0;k<size;k++){
                    map[j][k] = input.charAt(k) - '0';
                }
            }

            for(int j=0;j<size;j++){
                for(int k=0;k<size;k++){
                    cost[j][k] = Integer.MAX_VALUE;
                }
            }
            cost[0][0] = 0;
            min = Integer.MAX_VALUE;

            bfs();
            System.out.println("#"+(i+1)+" "+min);
        }
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new Point(0, 0));
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == size-1 && p.y == size-1){
                min = Math.min(min, cost[p.x][p.y]);
            }
            if(min <= cost[p.x][p.y]){
                continue;
            }
            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>= size || ny>= size) continue;
                if(!visited[nx][ny] || cost[p.x][p.y] + map[nx][ny] < cost[nx][ny]) {
                    // 최소값이 갱신.
                    cost[nx][ny] = cost[p.x][p.y] + map[nx][ny];
                    q.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}