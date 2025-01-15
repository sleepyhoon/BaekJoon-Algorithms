import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] parents;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        parents = new int[n];

        for(int i=0;i<n;i++){
            parents[i] = i;
        }

        for(int i=0;i<m;i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            if(findParent(from) == findParent(to)) {
                answer = i+1;
                break;
            }
            union(from,to);
        }
        System.out.println(answer);
    }

    private static int findParent(int x) {
        if(x == parents[x])
            return x;
        else
            return findParent(parents[x]);
    }

    private static void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if(px > py)
            parents[px] = py;
        else
            parents[py] = px;
    }
}
