

import java.util.Scanner;

public class Main {
	static int answer;
	static int n;
	static int[] list;
	static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new int[n];
        nums = new int[10];
        // 리스트 안에 탕후루 넣기
        for(int i = 0; i < n; i++) {
            int input = sc.nextInt();
            list[i] = input;
        }
        System.out.println(twoPointer(0,0,0,0,0));
    }

	private static int twoPointer(int left, int right,int kind,int length,int max) {
		if(right>=n)
			return max;
		if(nums[list[right]]==0) {
			kind++;
		}
		nums[list[right]]++;
		length++;
		
		if(kind>2) {
			nums[list[left]]--;
			length--;
			if(nums[list[left]]==0) {
				kind--;
			}
			left++;
		}
		max = Math.max(max, length);
		return twoPointer(left,right+1,kind,length,max);
	}
}