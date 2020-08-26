package algorithm_8_4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈출_백준3055 {
	static int R, C;
	static char[][] arr;
	static int[] dir = { -1, 1, 0, 0 };
	static int[] dic = { 0, 0, -1, 1 };
	static Queue<Point> Q = new LinkedList<>();
	static int[][] cnt;

	static class Point {
		int x, y;
		char c;

		public Point(int x, int y, char c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();

		arr = new char[R][C];
		cnt = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == '*') {
					Q.add(new Point(i, j, '*'));

				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 'S') {
					Q.add(new Point(i, j, 'S'));
				}
			}
		}

		bfs();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 'D') {
					if (cnt[i][j] == 0) {
						System.out.println("KAKTUS");
						return;
					}
					System.out.print(cnt[i][j]);
					return;
				}
			}
		}
	}

	private static void bfs() {

		while (!Q.isEmpty()) {

			Point p = Q.poll();

			for (int k = 0; k < 4; k++) {

				int nr = p.x + dir[k];
				int nc = p.y + dic[k];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
					continue;
				}
				if (p.c == '*') {
					if (arr[nr][nc] != 'X' && arr[nr][nc] != 'D' && arr[nr][nc] != '*') {
						arr[nr][nc] = '*';
						Q.add(new Point(nr, nc, p.c));
					}

				} else {
					if ((arr[nr][nc] == '.' || arr[nr][nc] == 'D') && arr[nr][nc] != 'X') {
						cnt[nr][nc] = cnt[p.x][p.y] + 1;

						if (arr[nr][nc] == 'D') {
							return;
						}
						arr[nr][nc] = 'S';
						Q.add(new Point(nr, nc, p.c));
					}
				}
			}

		}
	}

}
