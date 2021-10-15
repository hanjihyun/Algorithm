package algorithm_2110;

import java.util.Scanner;

public class 합구하기_백준 {
	static int N, M, K;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		arr = new int[N+1];

		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i-1] + sc.nextInt();
		}

		M = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < M; i++) {
			sum = 0;
			int x = sc.nextInt();
			int y = sc.nextInt();

			sum = arr[y]-arr[x-1];
			System.out.println(sum);
		}
	}
}
