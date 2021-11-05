package algorithm_2111;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_백준7569 {
	static int N, M, H, Ans;
	static int[][][] tomato;

	static int[] dr = { -1, 0, 1, 0, 0, 0 }; // 상하좌우위아래
	static int[] dc = { 0, 1, 0, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static Queue<Point> q = new LinkedList<Point>();

	static class Point {
		int r, c, z; // 세로 가로 면

		Point(int z, int r, int c) {
			super();
			this.z = z;
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();

		tomato = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					tomato[i][j][k] = sc.nextInt();
					if (tomato[i][j][k] == 1)
						q.add(new Point(i, j, k));
				}
			}
		}

		Ans = bfs();

		System.out.println(Ans);
	}

	private static int bfs() {
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 6; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				int nz = p.z + dz[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || nz < 0 || nz >= H) {
					continue;
				}
				if (tomato[nz][nr][nc] == 0) {
					q.add(new Point(nz, nr, nc));
					tomato[nz][nr][nc] = tomato[p.z][p.r][p.c] + 1;

				}
			}
		}
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (tomato[i][j][k] == 0)
						return -1;
					result = Math.max(result, tomato[i][j][k]);
				}
			}
		}
		if (result == 1)
			return 0;
		else
			return result - 1;
	}
}
