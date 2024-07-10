import java.util.*;
import java.io.*;

public class Main
{
    static int n,m;
    static boolean[] visited;
    static int[] list;
    static HashMap<Integer,Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[101];
        map = new HashMap<>();
        list = new int[101];
        // 사다리 정보 입력
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map.put(from,to);
        }
        // 뱀 정보 입력
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map.put(from,to);
        }
        bfs();
        System.out.print(list[100]);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.offer(1);
        while(!q.isEmpty()){
            int start = q.poll();
            for(int i=1;i<=6;i++){
                int newStart = start + i;
                if(newStart == 100) {
                    list[newStart] = list[start] + 1;
                    return; // 100에 도착한 경우
                }
                if(newStart > 100) continue; // 100을 초과하는 경우
                if(visited[newStart]) continue; // 이미 방문한 곳인 경우
                if(map.containsKey(newStart)) {
                    newStart = map.get(newStart);
                }
                visited[newStart] = true;
                if(list[newStart]==0) {
                    list[newStart] = list[start] + 1;
                }
                q.offer(newStart);
            }
        }
    }
}