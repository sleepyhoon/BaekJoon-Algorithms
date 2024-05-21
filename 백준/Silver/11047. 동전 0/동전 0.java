import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> coins = new ArrayList<Integer>();
        while(n-->0){
            int coin = sc.nextInt();
            coins.add(coin);
        }
        int answer = 0;
        int size = coins.size();
        if(coins.get(size-1)<=k) {
            // 금액이 사이에 존재하지 않음
            int tmp = k/coins.get(size-1);
            k -= tmp*coins.get(size-1);
            answer+=tmp;
        }
        int start = size - 2;
        while(k!=0){
            int i = 0;
            // 사이에 존재함.
            if(coins.get(start)<=k){
                int tmp = k/coins.get(start);
                k -= tmp*coins.get(start);
                answer+=tmp;
            }
            start--;
        }
        System.out.println(answer);
    }
}