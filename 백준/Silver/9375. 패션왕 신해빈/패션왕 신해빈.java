import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 옷의 정보를 입력 받음. <이름 종류> 한번 입을 때 같은 종류의 옷은 1개만 입을 수 있음.
        // 저장할 때 쌍으로 저장하는게 편해보이긴함. 객체로 만들어서 생성하자.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(t-->0) {
            int answer = 1;
            st = new StringTokenizer(br.readLine());
            Map<String,Integer> map = new HashMap<>();
            int n = Integer.parseInt(st.nextToken());
            while(n-->0) {
                st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String kind = st.nextToken();
                map.put(kind,map.getOrDefault(kind,0)+1);
            }
            for (Integer value : map.values()) {
                answer *= (value+1);
            }
            System.out.println(answer-1);
        }
    }
}

