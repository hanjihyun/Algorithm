package algorithm_10_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class 말이되고픈원숭이_백준1600 {
	static int K,W,H,Ans;
	static int[][] map;
	static boolean[][][] v;
	static int[] dr = {1,-1,0,0,-2,-1,1,2,2,1,-1,-2};
	static int[] dc = {0,0,1,-1, 1,2,2,1,-1,-2,-2,-1};
	
	static class Point {
		int r,c,cnt,k;

		Point(int r, int c, int cnt, int k) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		v = new boolean[H][W][K+1];
		Ans = Integer.MAX_VALUE;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		bfs(0,0);
		System.out.println(Ans == Integer.MAX_VALUE?-1:Ans);
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y, 0, K));
		v[x][y][K] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.r == H-1 && p.c == W-1) {
				Ans = Math.min(Ans , p.cnt);
				break;
			}
			for (int i = 0; i < (p.k>0? 12:4); i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				int nk = i<4? p.k : p.k-1;
				
				if(nr<0 || nr>=H || nc<0 || nc>=W) {
					continue;
				}
				if(!v[nr][nc][nk] && map[nr][nc]!=1) {
					v[nr][nc][nk] = true;
					q.add(new Point(nr, nc, p.cnt+1, nk));
				}
			}
		}
	}
}

