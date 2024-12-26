import java.util.Scanner;

public class Main {
    static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        arr = new char[n][n];

        func(0,0,n,false);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void func(int x,int y, int n,boolean blank) {
        if(blank) {
            for(int i=x;i<x+n;i++){
                for(int j=y;j<y+n;j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        if(n==1) {
            arr[x][y] = '*';
            return;
        }

        int newSize = n/3;
        int count = 0;

        for(int i=x;i<x+n;i+=newSize) {
            for(int j=y;j<y+n;j+=newSize) {
                count++;
                if(count==5)
                    func(i,j,newSize,true);
                else
                    func(i,j,newSize,false);
            }
        }
    }
}
