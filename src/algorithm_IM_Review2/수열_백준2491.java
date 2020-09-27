package algorithm_IM_Review2;

import java.util.Scanner;

public class 수열_백준2491 {
	static int[] arr;
	static int N,max,len;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		max = 1;
		len = 1;
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i < N; i++) {
			if(arr[i-1] <= arr[i]) {
				len++;
			}else {
				len = 1;
			}
			if(len>max) {
				max = len;
			}
		}
		len=1;
		for (int i = 1; i < N; i++) {
			if(arr[i-1] >= arr[i]) {
				len++;
			}else {
				len = 1;
			}
			if(len>max) {
				max = len;
			}
		}
		System.out.println(max);
	}
}
