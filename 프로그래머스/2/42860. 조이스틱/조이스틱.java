class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        // 1. 상하 조작 횟수 계산 (각 문자마다 A에서 목표 문자까지의 최소 이동)
        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            int move = Math.min(c - 'A', 'Z' - c + 1);
            answer += move;
        }

        // 2. 좌우 커서 이동 최적화
        int move = length - 1; // 기본: 오른쪽으로 쭉 가는 경우
        for (int i = 0; i < length; i++) {
            int next = i + 1;

            // 연속된 A 구간의 끝까지 이동
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            // 좌로 갔다가 돌아오는 경우, 우로 갔다가 돌아오는 경우 중 최소
            int leftThenRight = i + length - next + Math.min(i, length - next);
            move = Math.min(move, leftThenRight);
        }

        answer += move;
        return answer;
    }
}
