import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr = new int[41][2]; // 1~40까지만 사용하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 초기값 설정
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;
        arr[2][0] = 1;
        arr[2][1] = 1;
        int count = sc.nextInt();
        for(int i=0;i<count;i++){
            int input = sc.nextInt();
            if(input<3)
                sb.append(arr[input][0]).append(" ").append(arr[input][1]).append('\n');
            else {
                for (int j = 3; j <= input; j++) {
                    arr[j][0] = arr[j - 1][0] + arr[j - 2][0];
                    arr[j][1] = arr[j - 1][1] + arr[j - 2][1];
                }
                sb.append(arr[input][0]).append(" ").append(arr[input][1]).append('\n');
            }
        }
        System.out.println(sb);
    }
}