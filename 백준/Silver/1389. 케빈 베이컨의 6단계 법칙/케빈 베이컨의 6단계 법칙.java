import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] cost;
    static ArrayList<ArrayList<Integer>> arr;
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        boolean[] chk = new boolean[n+1];
        cost = new int[n+1];
        q.offer(start);
        chk[start] = true;
        while(!q.isEmpty()){
            int poll = q.poll();
            for(int i=0;i<arr.get(poll).size();i++){
                int cur = arr.get(poll).get(i);
                if(!chk[cur]){
                    q.offer(cur);
                    cost[cur] = cost[poll] + 1;
                    chk[cur] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 유저의 수
        m = sc.nextInt(); // 관계의 수
        arr = new ArrayList<>();
        // 인덱스 0 은 사용하지 않음.
        for(int i=0;i<n+1;i++){
            arr.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            arr.get(from).add(to);
            arr.get(to).add(from);
        }
        // 케빈 베이컨이 가장 작은 학생의 번호
        int answer = 0;
        int min = Integer.MAX_VALUE;
        // 학생은 1~n까지만 존재한다.
        for(int i=1;i<=n;i++){
            bfs(i);
            int sum = 0;
            // 코스트 출력
            for (int i1 : cost) {
                sum+=i1;
            }
            if(min>sum) {
                min = sum;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}