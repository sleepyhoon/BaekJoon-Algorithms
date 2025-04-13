import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 2x + 2y - 4 = 10
        // x + y = 7
        
        // (y-2) * (x-2) = 2
        // xy -2(x+y) + 4 = 2
        // xy = 12
    
        int size = brown + yellow;
        List<Integer> list = new ArrayList<>();
        for(int i = 3; i <= Math.sqrt(size);i++){
            if(size%i==0)
                list.add(i);
        }
        for(int x : list) {
            int row = Math.max(x,size/x);
            int column = Math.min(x,size/x);
            
            if(2*row + 2*column - 4 == brown) {
                answer[0] = row;
                answer[1] = column;
                break;
            }
        }
        return answer;
    }
}