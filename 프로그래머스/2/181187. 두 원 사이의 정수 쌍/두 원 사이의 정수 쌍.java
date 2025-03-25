class Solution {
    public long solution(long r1, long r2) {
        long answer = 0;
        for(long i=1;i<r2;i++){
            if(i<r1) {
                answer += Math.floor(Math.sqrt(r2*r2 - i*i)) - Math.ceil(Math.sqrt(r1*r1 - i*i)) + 1;
            } else {
                answer += Math.floor(Math.sqrt(r2*r2 - i*i));
            }
        }
        answer *= 4;
        answer += (r2-r1+1)*4;
        return answer;
    }
}