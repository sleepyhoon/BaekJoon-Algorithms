import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[26];
        int index = 0;
        String s = br.readLine();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>91) // 소문자라면
                index = s.charAt(i) - 'a';
            else
                index = s.charAt(i) - 'A';
            count[index]++;
        }
        int max = 0;
        int maxindex = 0;
        for (int i=0;i<count.length;i++) {
            if(max<count[i]) {
                max = count[i];
                maxindex = i;
            }
        }
        int maxcount = 0;
        for (int i : count) {
            if(i==max) maxcount++;
        }
        if(maxcount==1){
            int answer = 'A' + maxindex;
            System.out.println((char)answer);
        }
        else {
            System.out.println("?");
        }
    }
}