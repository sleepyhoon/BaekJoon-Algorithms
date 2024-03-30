import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            int input = sc.nextInt();
            if (input>0){
                q.offer(input);
            }
            else if (input==0){
                if(q.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(q.poll());
                }
            }
        }


    }
}
