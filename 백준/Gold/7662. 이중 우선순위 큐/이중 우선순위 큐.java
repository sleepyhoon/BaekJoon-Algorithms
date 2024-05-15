import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int input = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < input; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(op.equals("I")){
                    min.add(num);
                    max.add(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                else { // D인 경우
                    if(map.isEmpty()) continue;
                    PriorityQueue<Integer> pq = num==1 ? max : min;
                    delete(pq,map);
                }
            }
            if(map.isEmpty()) System.out.println("EMPTY");
            else {
                int n = delete(max,map);
                int m = !map.isEmpty() ? delete(min,map) : n;
                System.out.println(n+" "+m);
            }
        }
    }

    // min max가 동기화가 안되는 상황. 그래서 이를 해결하기 위해 map을 사용했는데 정확히 해결책이 무엇인가?
    private static int delete(PriorityQueue<Integer> pq,Map<Integer,Integer> map) {
        int del;
        while(true) {
            del = pq.poll();
            int count = map.getOrDefault(del,0);
            if(count == 0) continue;
            if(count == 1) map.remove(del);
            else map.put(del, map.get(del) -1);
            break;
        }
        return del;
    }
}