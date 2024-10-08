import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[] visited = new boolean[100001];
    static int min = Integer.MAX_VALUE;
    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int from = sc.nextInt();
        int to = sc.nextInt();

        bfs(from, to);
        System.out.println(min);

    }

    private static void bfs(int from, int to) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(from,0));
        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int time = node.time;
            visited[x] = true;
            if(x == to) {
                min = Math.min(min,time);
            }

            if(2*x <= 100000 && !visited[2*x]) {
                q.add(new Node(2*x,time));
            }
            if(x+1 <= 100000 && !visited[x+1]) {
                q.add(new Node(x+1,time+1));
            }
            if(x-1 >= 0 && !visited[x-1]) {
                q.add(new Node(x-1,time+1));
            }
        }
    }
}