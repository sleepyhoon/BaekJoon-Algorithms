class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int sp = 0;
        int[] stack = new int[ingredient.length];
        for(int i:ingredient){
            stack[sp++]=i;
            if(sp>=4 && stack[sp-1] == 1
              && stack[sp-2] == 3
              && stack[sp-3] == 2
              && stack[sp-4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }
}