package algorithm_2110;

import java.util.Scanner;

public class 구간합구하기4_백준 {
	static int N, M, K;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + sc.nextInt();
		}

		int sum = 0;
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sum = 0;
			sum = arr[y] - arr[x - 1];
			System.out.println(sum);
		}
	}
}
