import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main{
    static int n,m;
    static int[][] rel;
    static final int INF = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        rel = new int[n+1][n+1];
        // 거리 초기화 하기
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) {
                    rel[i][j] = 0;
                }
                else rel[i][j] = INF;
            }
        }
        // 인접한 점끼리의 거리는 1이다.
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            rel[from][to] = 1;
            rel[to][from] = 1;
        }
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    rel[i][j] = min(rel[i][j],rel[i][k]+rel[k][j]);
                }
            }
        }
        int result = 0;
        int min = INF;
        for(int i=1;i<=n;i++){
            int sum = 0;
            for(int j=1;j<=n;j++){
                sum += rel[i][j];
            }
            if(min>sum){
                min = sum;
                result = i;
            }
        }
        System.out.println(result);
    }
}