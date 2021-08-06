package algorithm_2108;

import java.util.Scanner;

public class 종이조각_백준14391 {
	static int N, M;
	static int[][] board;
	static boolean[][] v; // 방문 관리
	static int max; // 최댓값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		max = 0;
		v = new boolean[N][M];
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
		dfs(0, 0);
		System.out.println(max);
	}

	private static void dfs(int row, int col) {
		if (row >= N) {
			sum();
			return;
		}
		if (col >= M) {
			dfs(row + 1, 0);
			return;
		}
		// 가로 숫자로 사용
		v[row][col] = true;
		dfs(row, col + 1);

		// 세로 숫자로 사용
		v[row][col] = false;
		dfs(row, col + 1);
	}

	private static void sum() {
		int sum = 0;
		int temp = 0;
		for (int i = 0; i < N; i++) {
			temp = 0;
			for (int j = 0; j < M; j++) {
				if (v[i][j]) {
					temp *= 10;
					temp += board[i][j];
				} else {
					sum += temp;
					temp = 0;
				}
			}
			sum += temp;
		}
		for (int i = 0; i < M; i++) {
			temp = 0;
			for (int j = 0; j < N; j++) {
				if (!v[j][i]) {
					temp *= 10;
					temp += board[j][i];
				} else {
					sum += temp;
					temp = 0;
				}
			}
			sum += temp;
		}
		if (max < sum) {
			max = sum;
		}
	}
}
