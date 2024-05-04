import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int n;
    static int one; // 1로 채워짐
    static int zero; // 0으로 채워짐

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int Length = n;
        divide(0,0,Length);
        System.out.println(zero);
        System.out.println(one);
    }
    static void divide(int x, int y,int Length){
        if(colorCheck(x,y,Length)){
            if(arr[x][y]==0){
                zero++;
            }
            else
                one++;
            return;
        }
        else {
            int newLength = Length/2;

            divide(x,y,newLength);
            divide(x+newLength,y,newLength);
            divide(x,y+newLength,newLength);
            divide(x+newLength,y+newLength,newLength);
        }
    }

    static boolean colorCheck(int x,int y,int Length){
        int pivot = arr[x][y];
        for(int i=x;i<x+Length;i++){
            for(int j=y;j<y+Length;j++){
                if(pivot!=arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}