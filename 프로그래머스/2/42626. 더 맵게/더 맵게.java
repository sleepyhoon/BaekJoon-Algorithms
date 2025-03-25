import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            pq.offer(scoville[i]);
        }
        boolean flag = true;
        int count = 0;
        while(pq.peek() < K) {
            if(pq.size() <= 1) {
                flag = false;
                break;
            }
            int first = pq.poll();
            int second = pq.poll();
            
            int mixed = first + (2*second);
            count++;
            pq.offer(mixed);
        }
        if(flag){
            answer = count; 
        } else {
            answer = -1;
        }
        return answer;
    }
}