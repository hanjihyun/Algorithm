package algorithm_2110;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 단지번호붙이기_백준 {
	static int N, cnt;
	static int[][] home;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static List<Integer> list = new ArrayList<Integer>();

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

		N = sc.nextInt();
		home = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				home[i][j] = str.charAt(j) - '0';
			}
		}
		int count = 0; // 단지 수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (home[i][j] == 1) {
					count++;
					bfs(i, j);
					list.add(cnt);
					cnt = 0;
				}
			}
		}
		System.out.println(count);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<Point>();
		
		q.add(new Point(i, j));
		home[i][j] = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			cnt+=1;
			for (int k = 0; k < 4; k++) {
				int nr = p.a + dr[k];
				int nc = p.b + dc[k];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					continue;
				}
				else if (home[nr][nc] == 1) {
					home[nr][nc] = 0;
					q.add(new Point(nr, nc));
				}
			}
		}
	}
}
