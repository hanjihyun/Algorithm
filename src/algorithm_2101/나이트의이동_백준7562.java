package algorithm_2101;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의이동_백준7562 {
	static int T,N,Ans;
	static int[][] arr;
	static int[] dr = {-1,-2,-2,-1,1,2,2,1};
	static int[] dc = {-2,-1,1,2,2,1,-1,-2};
	static boolean[][] v;
	static Queue<Point> Q = new LinkedList<>();
	
	static class Point {
		int x, y,cnt;

		protected Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			Q = new LinkedList<>();
			N = sc.nextInt();
			arr = new int[N][N];
			v = new boolean[N][N];
			
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			Q.add(new Point(startX,startY,0));
			
			int endX = sc.nextInt();
			int endY = sc.nextInt();
			
			arr[startX][startY] = 1;
			arr[endX][endY] = 2;
			Ans=-1;
			bfs();
			System.out.println(Ans);
		}
		
	}

	private static void bfs() {
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			if(arr[p.x][p.y] == 2) {
				Ans = p.cnt;
				return;
			}
			
			for (int d = 0; d < 8; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc]) {
					continue;
				}
				if(!v[nr][nc]) {
					Q.add(new Point(nr, nc,p.cnt+1));
					v[nr][nc] = true;
				}
			}
		}
	}
}
