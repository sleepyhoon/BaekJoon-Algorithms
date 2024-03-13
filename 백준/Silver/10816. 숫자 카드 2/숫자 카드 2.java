import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class Main {
    static int[] arr;

    static int lowerBound(int target) {
        int left = 0;
        int right = arr.length;

        while(left<right){
            // 중간 위치를 구한다.
            int mid = (left + right) / 2;
            // 중복 원소에 대해서 왼쪽으로 탐색하도록 상계를 내린다.
            if (target<=arr[mid])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    static int upperBound(int target) {
        int left = 0;
        int right = arr.length;

        while(left<right){
            int mid = (left + right) / 2;

            if(target<arr[mid]){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 상근이가 가진 카드 입력하기
        int have = Integer.parseInt(br.readLine());
        arr = new int[have];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<have;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 몇개있는지 찾고 싶은 카드들 입력하기
        int find = Integer.parseInt(br.readLine());
        int[] arr2 = new int[find];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<find;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        // 상근이가 가지고 있는 카드 오름차순으로 정렬
        Arrays.sort(arr);
        // 상근이가 해당 카드를 몇 개 가지고 있는지 구하기
        for(int i=0;i<find;i++) {
            int target = arr2[i];

            sb.append(upperBound(target)-lowerBound(target)).append(' ');
        }
        System.out.println(sb);
    }
}