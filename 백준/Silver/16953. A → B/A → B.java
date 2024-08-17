import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int count = 0;
        while(start < end) {
            int tmp;
            if(end%2==0) {
                tmp = end/2;
            } else if (end%10==1){
                tmp = (end - 1) / 10;
            } else {
                break;
            }
            count++;
            end = tmp;
        }
        if(start==end) {
            System.out.println(count + 1);
        } else {
            System.out.println(-1);
        }
    }
}