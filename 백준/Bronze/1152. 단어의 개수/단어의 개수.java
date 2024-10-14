import java.io.BufferedReader;
import java.io.InputStreamReader;


// 1시 22분 시작
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        if(input.length == 0) {
            System.out.println(0);
        } else {
            if(input[0].isBlank()) System.out.println(input.length-1);
            else System.out.println(input.length);   
        }
    }
}