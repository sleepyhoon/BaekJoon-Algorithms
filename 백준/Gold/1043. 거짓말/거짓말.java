import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parents;
    static List<Integer> eList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int en = Integer.parseInt(st.nextToken());
        eList = new ArrayList<>();
        if (en == 0) {
            System.out.println(m);
            return;
        } else {
            for (int i = 0; i < en; i++) {
                eList.add(Integer.parseInt(st.nextToken()));
            }
        }

        // 이중 리스트 선언
        List<List<Integer>> partyList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            partyList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pn = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            partyList.get(i).add(x);
            for (int j = 1; j < pn; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                partyList.get(i).add(y);
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int num : partyList.get(i)) {
                if (eList.contains(find(num))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]); // 경로 압축
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (eList.contains(ry)) {
            int tmp = rx;
            rx = ry;
            ry = tmp;
        }
        parents[ry] = rx;
    }
}
