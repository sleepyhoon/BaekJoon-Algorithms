import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.pow;


public class Main {
    static int count = 0;
    static void find(int size,int r,int c){
        if(size==1)
            return;
        int newSize = size/2;
        if (r < newSize && c < newSize){ // 1사분면인 경우
            find(newSize,r,c);
        }
        else if (r<newSize && c>=newSize){ // 2사분면인 경우
            count+= newSize * newSize;
            find(newSize,r,c-newSize);
        }
        else if (r>=newSize && c<newSize){ // 3사분면인 경우
            count += newSize * newSize * 2;
            find(newSize,r-newSize,c);
        }
        else { // 4사분면인 경우
            count += newSize * newSize * 3;
            find(newSize,r-newSize,c-newSize);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int row = (int) pow(2,n);
        find(row,r,c);
        System.out.println(count);
    }
}