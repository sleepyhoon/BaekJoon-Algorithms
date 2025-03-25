import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();

        for (int num : numbers) {
            list.add(String.valueOf(num)); // 문자열로 변환해서 저장
        }

        // 내림차순 정렬: 조합한 문자열이 더 큰 게 앞에 오도록
        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));

        // 예외 처리: 전부 0일 경우 "0"
        if (list.get(0).equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }

        return sb.toString();
    }
}
