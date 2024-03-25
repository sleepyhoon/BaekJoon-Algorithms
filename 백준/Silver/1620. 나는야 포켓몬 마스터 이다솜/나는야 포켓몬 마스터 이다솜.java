import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        // 포켓몬 도감채우기
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            map1.put(i,s);
            map2.put(s,i);
        }
        // 문제 맞추기
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            // 입력받은게 숫자인지, 문자열인지 아스키코드로 판단하자.
            String s = st.nextToken();
            // 0~9 숫자는 48 ~ 57 까지의 아스키코드를 가진다. 이건 문자열인 경우
            if(s.charAt(0)>57){
                sb.append(map2.get(s)).append("\n");
            }
            // 0~9 숫자인 경우
            else {
                int index = Integer.parseInt(s);
                sb.append(map1.get(index)).append("\n");
            }
        }
        System.out.println(sb);
    }
}