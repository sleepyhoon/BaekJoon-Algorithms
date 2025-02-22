import java.util.*;

class Solution {
    static int max = -1;
    static int[] maxArr;
    public int[] solution(int n, int[] info) {
        maxArr = new int[11];
        int[] tmp = new int[11];
        dfs(tmp, info, n,n, 0);
        
        return max > -1 ? maxArr : new int[]{-1};
    }
    
    private static void dfs(int[] tmp, int[] info, int n, int remainingArrows, int idx) {
        if (idx == 10) {
            // 마지막 점수에서는 남은 화살을 모두 사용
            tmp[idx] = remainingArrows;
            compareScore(tmp, info);
            tmp[idx] = 0; // 백트래킹
            return;
        }

        // 1. 어피치보다 1개 더 많이 쏘는 경우 (가능할 때만)
        if (remainingArrows > info[idx]) {
            tmp[idx] = info[idx] + 1;
            dfs(tmp, info, n,remainingArrows - tmp[idx], idx + 1);
            tmp[idx] = 0; // 백트래킹
        }

        // 2. 해당 점수를 포기하는 경우
        dfs(tmp, info, n,remainingArrows, idx + 1);
    }
    private static void compareScore(int[] tmp, int[] info) {
        int peach = 0, lion = 0;
        
        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && tmp[i] == 0) continue;
            if (info[i] >= tmp[i]) peach += (10 - i);
            else lion += (10 - i);
        }

        if (lion > peach) {
            if (lion - peach > max) {
                max = lion - peach;
                maxArr = tmp.clone();
            } else if (lion - peach == max) {
                // 가장 낮은 점수를 많이 맞힌 경우를 선택
                for (int i = 10; i >= 0; i--) {
                    if (tmp[i] > maxArr[i]) {
                        maxArr = tmp.clone();
                        break;
                    } else if (tmp[i] < maxArr[i]) break;
                }
            }
        }
    }
}