import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int n, m, w;
    static List<Edge> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        // 음수 가중치가 있어서 다익스트라 사용 못함. 벨만포드 알고리즘을 사용해서 음의 사이클이 있는지 확인해야함.
        while (tc-- > 0) {
            graph = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            // 정상 도로 입력
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.add(new Edge(from, to, cost));
                graph.add(new Edge(to, from, cost));
            }

            // 웜홀 입력
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.add(new Edge(from, to, cost * -1));
            }

            if (BellmanFord()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    // 실책 1. 모든 정점을 거칠 필요가 없음. 임의의 한 점이면 음의 사이클을 확인 가능함 => 91%에서 시간 초과
    // 실책 2. 그렇다고 1번을 고정해서 해도되나? 이 1번이 음의 사이클에 포함이 되지 않으면 검출이 안되는데?
    // 실책 3. 그렇다면 웜홀의 from 을 시작점으로 하면 되지 않을까? 음의 사이클이면 웜홀을 무조건 거쳐야 하니까.. 이것도 실패
    // 실책 4. 웜홀이 graph 의 index 어디에 있는지 헷갈렸다. 정상 Edge가 2m개 존재하니 (0~2m-1) 웜홀은 graph.get(2*m)에 존재할 것이다.. 라고 가정했지만 다시 틀림
    private static boolean BellmanFord() {
        int[] dist = new int[n + 1];
        dist[1] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (Edge edge : graph) {
                if (dist[edge.from] != Integer.MAX_VALUE / 2 && dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    if (i == n) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
