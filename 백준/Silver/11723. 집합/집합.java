import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>(20);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("all") || s.equals("empty")) {
                func(s);
            }
            else {
                int input = Integer.parseInt(st.nextToken());
                func(s,input);
            }
        }
        System.out.println(sb);
    }

    private static void func(String s) {
         if(s.equals("all")) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i=1;i<=20;i++) {
                tmp.add(i);
            }
            list = tmp;
        }
        else {
            list.clear();
        }
    }

    static void func(String s,int a){
        if(s.equals("add")) {
            if(!list.contains(a)) {
                list.add(a);
            }
        }
        else if(s.equals("remove")) {
            if(list.contains(a)) {
                list.remove((Integer) a);
            }
        }
        else if(s.equals("toggle")) {
            if(list.contains(a)) {
                list.remove((Integer) a);
            }
            else
                list.add(a);
        }
        else if(s.equals("check")) {
            if(list.contains(a)) {
                sb.append(1).append("\n");
            }
            else {
                sb.append(0).append("\n");
            }
        }
    }
}