import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       ArrayList<Integer> list = new ArrayList<Integer>();
       StringTokenizer st = new StringTokenizer(br.readLine());
       while(n-->0){
           list.add(Integer.parseInt(st.nextToken()));
       }
       Collections.sort(list);
       int sum = 0;
       int size = list.size();
       for(int i=0; i<size; i++){
           sum += list.get(i)*(size-i);
       }
       System.out.println(sum);
    }
}
