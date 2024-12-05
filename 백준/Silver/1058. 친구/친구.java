import java.io.*;
import java.util.*;

class Main {
    static int n;
    static char[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            String string = br.readLine();
            for(int j=0;j<string.length();j++){
                arr[i][j] = string.charAt(j);
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            visited[i] = true;
            int depth = 0;
            int count = 0;

            while(depth < 2) {

                int size = q.size();

                for(int j=0;j<size;j++) {
                    Integer poll = q.poll();

                    for(int k=0;k<n;k++){
                        if (arr[poll][k] == 'Y' && !visited[k]) {
                            q.offer(k);
                            visited[k] = true;
                            count++;
                        }
                    }
                }
                depth++;
            }
            answer = Math.max(answer,count);
            Arrays.fill(visited,false);
        }

        System.out.println(answer);
    }


}
