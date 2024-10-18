import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
         // 각 멤버의 index를 저장한다. 이게 제일 킬포인트인듯
        Map<String,Integer> memberIndex = new HashMap<>();
        for(int i=0;i<friends.length;i++){
            memberIndex.put(friends[i],i);
        }

        // 선물 지수를 계산한다.
        int[] giftIndex = new int[friends.length];

        // 친구에게 선물을 준 횟수를 저장한다
        int[][] record = new int[friends.length][friends.length];

        for(int i=0;i< gifts.length;i++){
            String from = gifts[i].split(" ")[0];
            String to = gifts[i].split(" ")[1];

            giftIndex[memberIndex.get(from)]++;
            giftIndex[memberIndex.get(to)]--;
            record[memberIndex.get(from)][memberIndex.get(to)]++;
        }

        int answer = 0;

        for(int i=0;i<friends.length;i++){
            // i 번째 친구가 받을 수 있는 선물의 개수
            int count = 0;
            for(int j=0;j< friends.length;j++){
                if(i==j) continue;
                if(record[i][j] > record[j][i]) count++;
                else if(record[i][j] == record[j][i] && giftIndex[i] > giftIndex[j]) count++;
            }
            answer = Math.max(answer,count);
        }
        return answer;
    }
}