package algorithm_2110;

import java.util.Scanner;

public class 수열_백준2559 {
	static int N, K, Ans = Integer.MIN_VALUE;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i <= N - K; i++) {
			int s = 0;
			for (int j = i; j < i + K; j++) {
				s += arr[j];
			}
			Ans = Math.max(Ans, s);
		}
		System.out.println(Ans);
	}
}
