package algorithm_2108;

import java.util.Scanner;

public class 꽃길_백준14620 {
	static int N;

	static int[][] ground;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int Ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		ground = new int[N+1][N+1];
		v = new boolean[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ground[i][j] = sc.nextInt();
			}
		}
		dfs(0, 0);

		System.out.println(Ans);
	}

	private static void dfs(int cnt, int sum) {
		if (cnt == 3) {

			Ans = Math.min(Ans, sum);

		} else {

			for (int i = 2; i < N; i++) {
				for (int j = 2; j < N; j++) {
					if (!v[i][j] && check(i, j)) {
						v[i][j] = true;

						int hap = ground[i][j];

						for (int k = 0; k < 4; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
						
							v[nr][nc] = true;
							hap += ground[nr][nc];
						}

						dfs(cnt+1, sum + hap);
						clear(i, j);
						v[i][j] = false;
					}
				}
			}

		}
	}


	private static boolean check(int x, int y) {

		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];

			if (v[nx][ny]) {
				return false;
			}
		}

		return true;

	}//

	private static void clear(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];

			v[nr][nc] = false;
		}

	}
}
