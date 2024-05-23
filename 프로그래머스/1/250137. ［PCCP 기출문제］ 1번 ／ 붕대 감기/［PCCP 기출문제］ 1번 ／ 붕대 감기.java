class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health; // 최대 체력 저장
        int timer = 0; // 지난 시간을 저장
        int healTime = 0; // 누적된 힐한 시간을 저장
        int index = 0; // 공격 웨이브의 인덱스 저장

        while(timer<=attacks[attacks.length-1][0]){
            // 몬스터가 공격하는 경우. 몬스터가 공격오는 시간과 timer을 비교
            if(attacks[index][0] == timer) {
                // 공격해서 피가 까임.
                health -= attacks[index][1];
                // 시전 시간을 0으로 만듬
                healTime = 0;
                index++;
                if(health<=0) {
                    health = -1;
                    break;
                }
            }
            // 공격을 받지 않고 최대 체력 미만인 경우 매초 힐을 해줌.
            else if(health<maxHealth){
                healTime++;
                if(healTime<bandage[0]) // 아직 시전 시간이 안됨.
                    health += bandage[1];
                else {
                    // 시전 시간이 다 됐음.
                    health += bandage[1] + bandage[2];
                    healTime=0;
                }
                if(health>maxHealth) // 힐한 체력이 최대 체력을 넘는 경우
                    health = maxHealth;
            }
            timer++;
        }
        return health;
    }
}