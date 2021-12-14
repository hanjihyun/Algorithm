package algorithm_2112;

import java.util.Scanner;

public class 로봇청소기_백준14503 {

	static int N, M, Ans;
	static int[][] arr;
	public static int[] dr = { -1, 0, 1, 0 }; // 북,동,남,서
	public static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];

		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		dfs(r, c, d);
		System.out.println(Ans);
	}

	private static void dfs(int r, int c, int d) {
		if (arr[r][c] == 0) {
			arr[r][c] = 2;
			Ans++;
		}
		boolean flag = false;
		int ori = d;

		for (int i = 0; i < 4; i++) {
			int nd = (d + 3) % 4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];

			if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
				if (arr[nr][nc] == 0) {
					dfs(nr, nc, nd);
					flag = true;
					break;
				}
			}
			d = (d + 3) % 4;
		}
		if (!flag) {
			int nd = (ori + 2) % 4;
			int nbr = r + dr[nd];
			int nbc = c + dc[nd];

			if (nbr > 0 && nbc > 0 && nbr < N && nbc < M) {
				if (arr[nbr][nbc] != 1) {
					dfs(nbr, nbc, ori);
				}
			}
		}
	}

}
