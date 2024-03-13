import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] arr;
    static int n;
    // 산술 평균
    static int sumAvg() {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        double avg = (double) sum / n;
        if (avg < 0) {
            // 반올림하는 Math.round함수
            return (int) Math.round(Math.abs(avg) * -1);
        } else {
            return (int) Math.round(avg);
        }
    }
    // 중앙값
    static int mid(){
        return arr[(n-1)/2];
    }
    // 최빈값
    static int most(){
        HashMap<Integer,Integer> map = new HashMap<>(); // 특정 숫자의 빈도 수 저장
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int maxValue = Collections.max(map.values()); // value의 최대값 저장
        ArrayList<Integer> list = new ArrayList<>(); // 최빈값을 가지는 key값을 저장
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == maxValue){
                list.add(entry.getKey());
            }
        }
        Collections.sort(list); // list도 다시 정렬
        if(list.size()>1)
            return list.get(1);
        else
            return list.get(0);
    }
    // 범위
    static int range(){
        int min = arr[0];
        int max = arr[n-1];
        return max-min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        sb.append(sumAvg()).append("\n").append(mid()).append("\n").append(most()).append("\n").append(range());
        System.out.println(sb);
    }
}