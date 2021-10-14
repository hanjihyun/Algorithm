package algorithm_2110;

import java.util.Scanner;

public class 섬의개수_백준 {
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static int w, h;
	static int[][] land;
	static boolean[][] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0) {
				break;
			}
			land = new int[h][w];
			v = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					land[i][j] = sc.nextInt();
				}
			}

			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (land[i][j] == 1 && !v[i][j]) {
						dfs(i, j);
						cnt++;
					}

				}
			}
			System.out.println(cnt);
		}
	}

	private static void dfs(int x, int y) {
		v[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];

			if (nr < 0 || nr >= h || nc < 0 || nc >= w || v[nr][nc]) {
				continue;
			}
			if (land[nr][nc] == 1 && !v[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}
}
