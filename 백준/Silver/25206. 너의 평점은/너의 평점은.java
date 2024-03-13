import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalsum = 0;
        double scoresum = 0;
        String str[] = new String[20];
        String[] gradelist = {"A+","A0","B+","B0","C+","C0","D+","D0","F","P"};
        double[] scorelist = {4.5,4.0,3.5,3.0,2.5,2.0,1.5,1.0,0.0,0.0};
        for(int i=0;i<20;i++){
            str[i] = br.readLine();
            StringTokenizer st = new StringTokenizer(str[i]," ");
            String subject = st.nextToken(); // 과목명 반환
            double score = Double.parseDouble(st.nextToken()); // 학점 반환 (문자열 -> 실수)
            String grade = st.nextToken(); // 점수 반환
            for (int j = 0; j < gradelist.length; j++) {
                if (grade.equals(gradelist[j])){
                    totalsum += score * scorelist[j];
                    if(j!=9)
                        scoresum += score;
                }
            }
        }
        double avg = totalsum/scoresum;
        System.out.println(avg);
    }
}