package algorithm_2110;

import java.util.Scanner;

public class 연결요소의개수_백준 {
	static int N, M, Ans;
	static int[][] arr;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N + 1][N + 1];
		v = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}

		for (int i = 1; i <= N; i++) {
			if (!v[i]) {
				dfs(i);
				Ans++;
			}
		}

		System.out.println(Ans);
	}

	private static void dfs(int i) {
		v[i] = true;

		for (int j = 1; j <= N; j++) {
			if (arr[i][j] == 1 && !v[j]) {
				dfs(j);
			}
		}

	}
}
