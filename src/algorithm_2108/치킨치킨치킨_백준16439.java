package algorithm_2108;

import java.util.Arrays;
import java.util.Scanner;

public class 치킨치킨치킨_백준16439 {
	static int N, M, sum;
	static int[] sel = new int[3], arr, maxT;
	static int[][] board;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		maxT = new int[N];
		arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = i + 1;
		}
		combination(0, 0);
		System.out.println(max);
	}

	private static void combination(int idx, int k) {
		if (k == sel.length) {
//			System.out.println(Arrays.toString(sel));

			int maxSum = 0;
			for (int j = 0; j < N; j++) {

				sum = 0;
				for (int i = 0; i < 3; i++) {
					if (sum < board[j][sel[i]]) {
						sum = board[j][sel[i]];
					}
				}
				maxT[j] = sum;
			}
			for (int i = 0; i < N; i++) {
				maxSum += maxT[i];
			}
//			System.out.println(maxSum);
			if (maxSum > max) {
				max = maxSum;
			}

			return;
		}

		for (int i = idx; i < M; i++) {
			sel[k] = i;
			combination(idx + 1, k + 1);
		}
	}
}
