package algorithm_8_1;

import java.util.Scanner;

public class 연산자끼워넣기_백준14888 {

	static int[] math; // 사칙연산 구분
	static int[] arr, arith;
	static boolean[] visit;
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N]; // 숫자 배열
		arith = new int[4]; // 사칙연산
		math = new int[4];
		visit = new boolean[arr.length];
//		int total = N+(N-1);
//		int[] cal = new int[total];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			// 숫자 입력 받기
			arr[i] = sc.nextInt();

		}

		for (int i = 0; i < 4; i++) {
			// 사칙연산 입력
			arith[i] = sc.nextInt();
//			if (arith[i] == 1) {
//				math[i] = i+1;
//				cnt++;
//			}
		}
		dfs(1, arr[0]);
		System.out.println(max);
		System.out.println(min);

	}

	private static void dfs(int count, int num) {

		for (int i = 0; i < 4; i++) {

			if (arith[i] != 0) {
				arith[i]--;
				switch (i) {

				case 0:
					dfs(count + 1, num + arr[count]);
					break;
				case 1:
					dfs(count + 1, num - arr[count]);
					break;
				case 2:
					dfs(count + 1, num * arr[count]);
					break;
				case 3:
					dfs(count + 1, num / arr[count]);
					break;

				}
				arith[i]++;
			}
		}
		if (count == N) {
			if (max < num) {
				max = num;
			}
			if (min > num) {
				min = num;
			}
		}

	}
}
