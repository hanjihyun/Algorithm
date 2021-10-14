package algorithm_2110;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 적록색약_백준 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, original, sick;
	static char[][] arr;
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

		arr = new char[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					bfs(i, j);
					original++;
				}
			}
		}
		System.out.println(original);
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'R') {
					arr[i][j] = 'G';
				}
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
		System.out.println(sick);
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		v[x][y] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = p.x + dr[i];
				int nc = p.y + dc[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) {
					continue;
				}
				if(!v[nr][nc] && arr[x][y] == arr[nr][nc]) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}
	}
}
