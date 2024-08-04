import java.util.*;

public class Main {

    static int[] arr;
    static int[] output;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        arr = new int[n+1];
        output = new int[r];
        visited = new boolean[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        permutation(0,n,r);
    }

    private static void permutation(int depth, int n, int r) {
        if(depth == r) {
            for (int i : output) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for(int i=1;i<n+1;i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    output[depth] = arr[i];
                    permutation(depth+1,n,r);
                    visited[i] = false;
                }
            }
        }
    }
}
