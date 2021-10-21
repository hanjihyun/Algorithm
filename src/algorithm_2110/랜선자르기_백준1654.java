package algorithm_2110;

import java.util.Scanner;

public class 랜선자르기_백준1654 {
	static int K;
	static long N;
	static long[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextLong();
		arr = new long[K];
		long max = 0;
		
		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
	
		long left = 1;
		long right = max;
		while(left<=right) {
			long mid = (left+right) / 2;
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i]/mid;
			}
			if(sum >= N) {
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		System.out.println(right);
		
	}
}
