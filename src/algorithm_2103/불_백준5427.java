package algorithm_2103;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 불_백준5427 {
	static int w, h;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] arr;
	static boolean[][] v;
	static Queue<Point> q, fire;

	static class Point {
		int x, y;

		protected Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			w = sc.nextInt();
			h = sc.nextInt();

			arr = new char[h][w];
			v = new boolean[h][w];
			q = new LinkedList<Point>();
			fire = new LinkedList<Point>();
//			Ans = Integer.MAX_VALUE;

			for (int i = 0; i < h; i++) {
				String str = sc.next();
				for (int j = 0; j < w; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '#') {
						v[i][j] = true;
					}else if (arr[i][j] == '*') {
						fire.add(new Point(i, j));
						v[i][j] = true;
					}else if (arr[i][j] == '@') {
						q.add(new Point(i, j));

					}
				}
			}
//			for (int i = 0; i < h; i++) {
//				for (int j = 0; j < w; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}

			bfs();
//			if (Ans == Integer.MAX_VALUE) {
//				System.out.println("IMPOSSIBLE");
//			} else {
//				System.out.println(Ans);
//			}
		}

	}

	private static void bfs() {
		int min = 1;
		while (!q.isEmpty()) {
			int fire_len = fire.size();
			for (int d = 0; d < fire_len; d++) {

				Point f = fire.poll();

				for (int j = 0; j < 4; j++) {

					int fr = f.x + dr[j];
					int fc = f.y + dc[j];

					if (fr >= 0 && fr < h && fc >= 0 && fc < w && !v[fr][fc]) {
						v[fr][fc] = true;
						fire.add(new Point(fr, fc));
					}

				}
			}

			int person_len = q.size();
			for (int k = 0; k < person_len; k++) {

				Point p = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = p.x + dr[i];
					int nc = p.y + dc[i];

					if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
						System.out.println(min);
						return;
					}

					if (!v[nr][nc]) {
						v[nr][nc] = true;
						q.add(new Point(nr, nc));
					}

				}
			}
			min++;
		}
		System.out.println("IMPOSSIBLE");
	}
}
