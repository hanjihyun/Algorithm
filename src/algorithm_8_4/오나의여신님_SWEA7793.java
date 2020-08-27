package algorithm_8_4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import algorithm_8_4.탈출_백준3055.Point;

public class 오나의여신님_SWEA7793 {

	static int N, M;
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

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", c=" + c + "]";
		}

	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();

			arr = new char[N][M];
			cnt = new int[N][M];

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == 'S') {
						Q.add(new Point(i, j, 'S'));
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == '*') {
						Q.add(new Point(i, j, '*'));
					}
				}
			}
			bfs();
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 'D') {
						if (cnt[i][j] == 0) {
							System.out.print("GAME OVER");
							break;
						}
						System.out.print(cnt[i][j]);
						break;

					}
				}
			}
		}

	}

	private static void bfs() {

		while (!Q.isEmpty()) {
			Point p = Q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.x + dir[i];
				int nc = p.y + dic[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}

				if (p.c == 'S') {
					if ((arr[nr][nc] != '*' || arr[nr][nc] != 'X') && arr[nr][nc] == '.' || arr[nr][nc] == 'D' ) {
						cnt[nr][nc] = cnt[p.x][p.y] + 1; // 이동할 수 있으면 이동 카운트 +1
						
						if (arr[nr][nc] == 'D') {
							return;
						}
						arr[nr][nc] = 'S';
						Q.add(new Point(nr, nc, p.c));
					}
				} else if(p.c == '*') {
					if (arr[nr][nc] != 'X' && arr[nr][nc] != 'D' && arr[nr][nc] != '*') {
						arr[nr][nc] = '*';
						Q.add(new Point(nr, nc, p.c));
					}
				}
			}
		}
	}
}
