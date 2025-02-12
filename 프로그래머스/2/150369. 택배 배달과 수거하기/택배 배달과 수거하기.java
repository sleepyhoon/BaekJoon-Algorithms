class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int index1 = n-1;
        int index2 = n-1;

        while(index1 != -1 || index2 != -1) {
            int current = 0;
            int pickup = cap;
            int tmp1 = -1;
            int tmp2 = -1;
            // 배송지에 대한 index 구하기
            while(index1 != -1) {
                if(deliveries[index1] != 0 && tmp1 == -1) {
                    tmp1 = index1;
                }
                if(current + deliveries[index1] <= cap) {
                    current += deliveries[index1];
                    deliveries[index1--] = 0;
                } else {
                    deliveries[index1] -= (cap - current);
                    break;
                }
            }
            // 수거지에 대한 index 구하기
            while(index2 != -1) {
                if(pickups[index2] != 0 && tmp2 == -1) {
                    tmp2 = index2;
                }
                if(pickup >= pickups[index2]) {
                    pickup -= pickups[index2];
                    pickups[index2--] = 0;
                } else {
                    pickups[index2] -= pickup;
                    break;
                }
            }
            answer += (long) 2 * Math.max(tmp1+1,tmp2+1);
        }
        
        return answer;
    }
}