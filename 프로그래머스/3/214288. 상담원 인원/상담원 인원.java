import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int[] tmp = new int[k]; // 각 상담 유형별 멘토 수
        Arrays.fill(tmp, 1);    // 최소 1명씩 할당
        return dfs(tmp, 0, n, k, 0, reqs, Integer.MAX_VALUE);
    }

    private int dfs(int[] tmp, int idx, int n, int k, int added, 
                int[][] reqs, int best) {

        if (added == n - k) {                // 모든 멘토 배치 완료
            return Math.min(best, counsel(reqs, tmp));
        }

        int min = best;
        for (int i = idx; i < k; i++) {      // ★ idx 부터!
            tmp[i]++;
            min = dfs(tmp, i, n, k, added + 1, reqs, min);
            tmp[i]--;                        // back-track
        }
        return min;
}

    private int counsel(int[][] reqs, int[] mentorPerType) {
        int totalWait = 0;
        int k = mentorPerType.length;

        // 상담 유형별 멘토 종료시간 저장용 PQ
        PriorityQueue<Integer>[] mentorEndTimes = new PriorityQueue[k];
        for (int i = 0; i < k; i++) {
            mentorEndTimes[i] = new PriorityQueue<>();
        }

        for (int[] req : reqs) {
            int start = req[0];
            int duration = req[1];
            int type = req[2] - 1;

            PriorityQueue<Integer> pq = mentorEndTimes[type];

            // 멘토 수를 초과하지 않도록 유지
            while (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll(); // 상담이 끝난 멘토 제거
            }

            if (pq.size() < mentorPerType[type]) {
                pq.offer(start + duration); // 바로 상담 가능
            } else {
                int earliestEnd = pq.poll();
                totalWait += earliestEnd - start;
                pq.offer(earliestEnd + duration); // 상담 대기 후 시작
            }
        }

        return totalWait;
    }
}
