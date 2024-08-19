import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] list;
    static boolean[] visited;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n];
        int[] output = new int[m];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        permutation(output,0);

    }

    private static void permutation(int[] output, int depth) {
        if(depth == m) {
            for(int i:output) {
                System.out.print(i+" ");
            }
            System.out.println();
        } else {
            int before = 0;
            for(int i=0;i<n;i++){
                if(!visited[i] && before != list[i]) {
                    visited[i] = true;
                    output[depth] = list[i];
                    before = list[i];
                    permutation(output,depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}