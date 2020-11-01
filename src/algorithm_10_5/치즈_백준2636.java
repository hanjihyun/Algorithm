package algorithm_10_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class 치즈_백준2636 {
	static int row,col,time,czCnt;
	static int[][] cheese;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		
		cheese = new int[row][col];
		v = new boolean[row][col];
		
		int cnt = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				cheese[i][j] = sc.nextInt();
				if(cheese[i][j] == 1) {cnt++;}
			}
		}
		while(true) {
			bfs();
			time++;
			boolean loop = true;
			czCnt = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if(cheese[i][j] != 0) {
						loop = false;
						czCnt++;
					}
				}
			}
			if (loop) break;
			cnt = czCnt;
			v = new boolean[row][col];
		}
		System.out.println(time);
		System.out.println(cnt);
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0));

		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr<0 || nr >= row || nc<0 || nc>=col) {
					continue;
				}
				if(!v[nr][nc] && cheese[nr][nc]==0) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc));
				}else {
					v[nr][nc] = true;
					cheese[nr][nc]=0;
				}
			}
		}
		
	}
}
