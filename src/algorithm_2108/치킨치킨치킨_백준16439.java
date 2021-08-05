package algorithm_2108;

import java.util.Arrays;
import java.util.Scanner;

public class 치킨치킨치킨_백준16439 {
	static int N, M;
	static int[] sel = new int[3],arr;
	static int[][] board;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		board = new int[N+1][M+1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = i+1;
		}
		combination(0, 0);
		System.out.println(max);
	}

	private static void combination(int idx, int k) {
		if (k == sel.length) {
			System.out.println(Arrays.toString(sel));
		
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				
				for (int j = 1; j <= N; j++) {
					sum += board[j][sel[i]];
				}
				
			}
			System.out.println(sum);
			if(sum > max) {
				max = sum;
			}
			
			return;
		}
		if (idx == arr.length) {

			return;
		}
		sel[k] = arr[idx];
		combination(idx + 1, k + 1);
		combination(idx + 1, k);
	}
}
