import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] origin = new int[n];
        int[] sorted = new int[n];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sorted);

        int rank = 0;
        for (int i : sorted) {
            // 중복된 앞선 원소가 이미 우선순위가 매겨졌다면 중복되면 안되므로, 원소가 중복되지 않을때만 대입한다.
            if(!map.containsKey(i)){
                map.put(i,rank);
                rank++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : origin) {
            int ranking = map.get(i);
            sb.append(ranking).append(' ');
        }
        System.out.println(sb);
    }
}