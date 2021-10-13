package algorithm_2110;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 유기농배추_백준 {
	static int T, M, N, K, Ans;
	static int[][] arr;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int a, b;

		Point(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			Ans = 0;
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();

			arr = new int[N][M];
			v = new boolean[N][N];

			for (int j = 0; j < K; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				arr[b][a] = 1;
			}

			for (int j = 0; j < N; j++) {
				for (int h = 0; h < M; h++) {
					if (arr[j][h] == 1) {
						bfs(j,h);
						Ans++;
					}
				}
			}
			System.out.println(Ans);
		}
	}

	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i, j));
		arr[i][j] = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.a + dr[k];
				int nc = p.b + dc[k];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					
					continue;
				}
				if (arr[nr][nc] == 1) {
					arr[nr][nc] = 0;
					q.add(new Point(nr, nc));
				}
			}
		}
	}
}
