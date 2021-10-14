package algorithm_2110;

import java.util.Scanner;

public class 안전영역_백준 {
	static int N, Ans;
	static int[][] area;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int x, y;

		Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		area = new int[N][N];
		v = new boolean[N][N];
		int minA = Integer.MAX_VALUE;
		int maxA = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				area[i][j] = sc.nextInt();
				if (minA > area[i][j]) {
					minA = area[i][j];
				}
				if (maxA < area[i][j]) {
					maxA = area[i][j];
				}
			}
		}
//		System.out.println(minA + " " + maxA);
		int cnt = 0;
		int Ans = Integer.MIN_VALUE;
		for (int h = minA; h <= maxA; h++) {
			v = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (area[i][j] > h && !v[i][j]) {
						cnt++;
						v[i][j] = true;
						dfs(i, j, h);
					}
				}
			}
			if (Ans < cnt) {
				Ans = cnt;
			}
		}
		System.out.println(Ans == 0 ? 1 : Ans);
	}

	private static void dfs(int x, int y, int water) {

		for (int k = 0; k < 4; k++) {
			int nr = x + dr[k];
			int nc = y + dc[k];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N || area[nr][nc] <= water || v[nr][nc]) {
				continue;
			}
		
			v[nr][nc] = true;
			dfs(nr, nc, water);
		}
	}
}
