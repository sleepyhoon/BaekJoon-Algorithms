import java.util.*;

class Solution {
    static class Progress {
        int start;
        int speed;
        
        Progress(int st, int sp) {
            this.start = st;
            speed = sp;
        }
    }
    public int[] solution(int[] p, int[] s) {
        List<Integer> answer = new ArrayList<>();
        
        Stack<Progress> st = new Stack<>();
        
        for(int i=p.length-1;i>=0;i--) {
            st.push(new Progress(p[i],s[i]));
        }
        
        int day = 1;
        int sum = 0;
        while(!st.isEmpty()) {
            while (!st.isEmpty()&& st.peek().start + day*st.peek().speed >= 100) {
                st.pop();
                sum++;
            }
            
            if(sum!=0) {
                answer.add(sum);
                sum = 0;
            }
            day++;
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}