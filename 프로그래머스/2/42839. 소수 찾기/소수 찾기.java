import java.util.*;

class Solution {
    static boolean[] notPrime = new boolean[9999999];
    static boolean[] visited = new boolean[9999999];
    static int answer;
    public int solution(String numbers) {
        notPrime[1] = true;
        for(int i=2;i<4000;i++){
            for(int j=i*i;j<9999999;j+=i) {
                notPrime[j] = true;
            }
        }
        int length = numbers.length();
        for(int i=1;i<length+1;i++){
            permutation(numbers.toCharArray(), new ArrayList<>(), i, 0, new boolean[length]);
        }
        return answer;
    }
    
    private static void permutation(char[] numbers, List<Character> tmp, int target, int current, boolean[] check) {
        if(target == current) {
            String result = trim(tmp);
            if(result.length() == 0) {
                return;
            }
            int value = Integer.valueOf(result);
            if(visited[value]) {
                return;
            }
            if(notPrime[value]) {
                return;
            }
            visited[value] = true;
            answer++;
        } else {
            for(int i=0;i<numbers.length;i++){
                if(!check[i]) {
                    check[i] = true;
                    tmp.add(numbers[i]);
                    permutation(numbers,tmp,target,current+1,check);
                    tmp.remove(tmp.size()-1);
                    check[i] = false;
                }
            }
        }
    }
    
    private static String trim(List<Character> tmp) {
        boolean cleanStart = false;
        StringBuilder sb = new StringBuilder();
        for(char c : tmp) {
            if(!cleanStart && c == '0') {
                continue;
            }
            else {
                cleanStart = true;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}