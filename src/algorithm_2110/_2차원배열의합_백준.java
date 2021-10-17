package algorithm_2110;

import java.util.Scanner;

public class _2차원배열의합_백준 {
	static int N, M, K;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		K = sc.nextInt();
		int sum = 0;
		
		for (int k = 0; k < K; k++) {
			sum = 0;
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int l = i-1; l < x; l++) {
				for (int l2 = j-1; l2 < y; l2++) {
					sum+=arr[l][l2];
				}
			}
			System.out.println(sum);
		}
	}
}
