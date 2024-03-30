import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[][] arr = new int[input][2];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료 시간이 같다면 시작 시간을 기준으로 정렬
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int answer = 0;
        int tmp = 0;
        for(int i=0;i<input;i++) {
            if(tmp<=arr[i][0]){
                answer++;
                tmp = arr[i][1];
            }
        }
        System.out.println(answer);
    }
}
