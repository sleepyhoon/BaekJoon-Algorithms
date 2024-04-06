import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static  StringBuilder sb = new StringBuilder();
    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            boolean isError = false; // 에러 여부

            String cmd = br.readLine(); // RDD 입력
            int m = Integer.parseInt(br.readLine()); // 리스트의 길이 입력
            String arrStr = br.readLine(); // 리스트 입력
            char[] chars = cmd.toCharArray(); // 리스트를 한글자씩 접근하기 위해 char 선언
            Deque<Integer> deque = new LinkedList<>(); // 배열만들기

            // 리스트안에 숫자가 있는 경우
            if(arrStr.length()>2) {
                String[] split = arrStr.substring(1,arrStr.length()-1).split(",");
                for(int i=0;i<split.length;i++)
                    deque.add(Integer.parseInt(split[i]));
            }
            // 커맨드 실행
            boolean isReverse = false;
            for(int i=0;i<chars.length;i++){
                char ch = chars[i];
                if(ch=='R'){
                    // 뒤집기
                    if(isReverse)
                        isReverse = false;
                    else
                        isReverse = true;
                }
                else if(ch=='D'){
                    // pop하기
                    if(deque.isEmpty()){
                        isError = true;
                        break;
                    }
                    else if (isReverse) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                } else {
                    isError = true;
                    break;
                }
            }
            if(isError)
                sb.append("error\n");
            else
                print(deque,isReverse);
        }
        System.out.println(sb);
    }

    private static void print(Deque<Integer> deque, boolean isReverse) {
        if(deque.isEmpty()){
            sb.append("[]\n");
            return;
        }
        else {
            int size = deque.size();
            sb.append("[");
            if(isReverse){
                for(int i=0;i<size-1;i++){
                    sb.append(deque.pollLast()).append(",");
                }
            }
            else {
                for(int i=0;i<size-1;i++){
                    sb.append(deque.pollFirst()).append(",");
                }
            }
            sb.append(deque.poll()).append("]\n");
        }
    }
}