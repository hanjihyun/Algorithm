package algorithm_8_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 적록색약_백준10026 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, ori, sick;
	static char[][] map;
	static boolean[][] v;

	static public class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new char[N][N];
		v = new boolean[N][N];
		ori = 0;
		sick = 0;

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					bfs(i, j);
					ori++;
				}
			}
		}
		System.out.print(ori);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R') {
					map[i][j] = 'G';
				}
				v[i][j] = false;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					bfs(i, j);
					sick++;
				}
			}
		}
		System.out.print(" " + sick);
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		v[x][y] = true;
		q.add(new Point(x, y));
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.x + dr[i];
				int nc = p.y + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					continue;
				}
				if (!v[nr][nc] && map[x][y] == map[nr][nc]) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}
	}

}
