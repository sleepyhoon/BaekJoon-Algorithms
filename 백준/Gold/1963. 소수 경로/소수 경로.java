import java.util.*;
import java.io.*;

public class Main {
	//BFS에 Queue에 사용할 클래스
    static class changeNum{
        int num, count;
        public changeNum(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    static boolean[] decimal = new boolean[10000];	//1000~9999 소수 확인 배열
    static public void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        //에라토스테네스의 체을 이용해서 1000~9999 범위의 소수 구하기
        for(int i=2;i<10000;i++){
            if(!decimal[i]){
                for(int j=i*2;j<10000;j+=i){
                    decimal[j] = true;
                }
            }
        }
        //TC에 대한 숫자들을 저장 및 BFS 탐색 수행
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine()," ");
            int cur = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());
            int result = bfs(cur,goal);
            if(result == -1)	//불가능한 경우
                bw.write("Impossible\n");
            else		//해당 숫자 최소 변경했을 때
                bw.write(result + "\n");
        }
        bw.flush();	//결과 출력
        bw.close();
        br.close();
    }
    //숫자 변경하는 BFS 탐색하는 함수
    static int bfs(int start, int goal){
        Queue<changeNum> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        visited[start] = true;
        queue.add(new changeNum(start, 0));
        while(!queue.isEmpty()){
            changeNum cur = queue.poll();
            int num = cur.num;
            int count = cur.count;
            if(num==goal)	//목표 숫자로 변경되었을 때
                return count;

            //일의 자리 바꾸기
            int n = num/10 * 10;
            for(int i=0;i<10;i++){
                int temp = n + i;
                if(!decimal[temp] && !visited[temp]){
                    visited[temp] = true;
                    queue.add(new changeNum(temp,count+1));
                }
            }
            //십의 자리 바꾸기
            n = (num/100 * 100) + (num%10);
            for(int i=0;i<10;i++){
                int temp = n + i*10;
                if(!decimal[temp] && !visited[temp]){
                    visited[temp] = true;
                    queue.add(new changeNum(temp,count+1));
                }
            }
            //백의 자리 바꾸기
            n = (num/1000 * 1000) + (num%100);
            for(int i=0;i<10;i++){
                int temp = n + i*100;
                if(!decimal[temp] && !visited[temp]){
                    visited[temp] = true;
                    queue.add(new changeNum(temp,count+1));
                }
            }
            //천의 자리 바꾸기
            n = num%1000;
            for(int i=1;i<10;i++){
                int temp = n + i*1000;
                if(!decimal[temp] && !visited[temp]){
                    visited[temp] = true;
                    queue.add(new changeNum(temp,count+1));
                }
            }
        }
        return -1;		//목표 숫자 도달 불가능시
    }
}