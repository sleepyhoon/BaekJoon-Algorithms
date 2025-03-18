import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, parents, heights;
    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        parents = new int[n + 1];
        Arrays.fill(parents, -1);
        heights = new int[n + 1];
        Arrays.fill(heights, 0);
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                int element = Integer.parseInt(st.nextToken());
                graph.get(i).add(element);
                union(i, element);
            }
        }

        for (int i = 1; i < n; i++) {
            combination(new ArrayList<>(), 1, i);
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void combination(List<Integer> tmp, int start, int size) {
        if (tmp.size() == size) {
            // 일단 가능한 방법인지 부터 구해야 한다.
            List<Integer> other = initList(tmp);
            if (!check(tmp, other)) {
                return;
            }
            // 인구 수 차이가 최소인지를 본다.
            int first = 0;
            int second = 0;

            for (int i = 1; i < n + 1; i++) {
                if (tmp.contains(i)) {
                    first += arr[i];
                } else {
                    second += arr[i];
                }
            }
            answer = Math.min(answer, Math.abs(first - second));
        } else {
            for (int i = start; i < n + 1; i++) {
                tmp.add(i);
                combination(tmp, i + 1, size);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private static boolean check(List<Integer> tmp, List<Integer> other) {
        boolean[] visited = new boolean[n + 1];

        traverse(other, tmp, visited);
        traverse(tmp, other, visited);

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private static void traverse(List<Integer> tmp, List<Integer> other, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(other.get(0));
        visited[other.get(0)] = true;
        while (!q.isEmpty()) {
            Integer poll = q.poll();

            for (int i = 0; i < graph.get(poll).size(); i++) {
                int cur = graph.get(poll).get(i);
                if (visited[cur] || tmp.contains(cur)) {
                    continue;
                }
                visited[cur] = true;
                q.offer(cur);
            }
        }
    }

    private static boolean isImpossible(List<Integer> tmp) {
        int parent = 0;
        for (Integer i : tmp) {
            if (parents[i] < 0) {
                continue;
            }
            if(parent == 0) {
                parent = parents[i];
            } else if (parent != parents[i]) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> initList(List<Integer> tmp) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (tmp.contains(i)) {
                continue;
            }
            list.add(i);
        }
        return list;
    }

    private static int findParents(int x) {
        if (parents[x] < 0) {
            return x;
        }
        return parents[x] = findParents(parents[x]);
    }

    private static void union(int a, int b) {
        int pa = findParents(a);
        int pb = findParents(b);

        if (pa == pb) {
            return;
        }

        if (heights[pa] < heights[pb]) {
            int tmp = pa;
            pa = pb;
            pb = tmp;
        }

        if (heights[pa] == heights[pb]) {
            heights[pa]++;
        }
        parents[pa] += parents[pb];
        parents[pb] = pa;
        heights[pb] = 0;
    }
}
