import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int prev = 0; // 몇번째 대각선인지 찾기.
        while(prev *(prev +1)/2<x){
            prev++;
        }
        if(prev%2==0){
            int a = 1;
            int b = prev;
            x -= prev*(prev-1)/2;
            while(x!=1){
                a++;
                b--;
                x--;
            }
            System.out.println(a+"/"+b);
        }
        else if(prev%2==1) {
            int a = prev;
            int b = 1;
            x -= prev*(prev-1)/2;
            while(x!=1){
                a--;
                b++;
                x--;
            }
            System.out.println(a+"/"+b);
        }
    }
}