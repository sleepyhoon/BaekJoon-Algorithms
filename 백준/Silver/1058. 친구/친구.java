import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        dist = new int[n][n];



        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < string.length(); j++) {
                if(string.charAt(j) == 'Y') {
                    dist[i][j] = 1;
                }
                else {
                    dist[i][j] = 100;
                }
            }
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++) {
                    if(i==j) continue;
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }

        int answer = 0;

        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(dist[i][j] == 1 || dist[i][j] == 2)
                    count++;
            }
            answer = Math.max(answer,count);
        }

        System.out.println(answer);

    }


}
