package algorithm_11_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽돌깨기_SWEA5656 {
	static int N,W,H,Ans;
	
	static int[] remain,breaking;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<Point> q = new LinkedList<Point>();
	static class Point{
		int x,y,range;

		Point(int x, int y, int range) {
			super();
			this.x = x;
			this.y = y;
			this.range = range;
		}
		
	}
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N=sc.nextInt();
			W=sc.nextInt();
			H=sc.nextInt();
			int[][] map = new int[H][W];
			
			remain = new int[W];
			breaking = new int[N];
			Ans = Integer.MAX_VALUE;
			
			int sum=0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j <W; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			dfs(0,map);
			System.out.println("#" + test_case + " " + Ans);
		}
	}
	//i번째 구슬을 떨어뜨리기
	private static boolean dfs(int k,int[][] map) { // k=던저진 구슬의 개수
		int result = getRemain(map);
		if(result == 0) {
			Ans = 0;
			return true;
		}
		if(k == N) {
			//남아잇는 벽돌의 개수를 구하여 최소값 갱신
			if(Ans>result) Ans = result;
			
			return false;
		}
		int[][] copy = new int[H][W];
		for (int i = 0; i < W; i++) {
			int r = 0;
			while(r<H && map[r][i]==0) ++r;
			
			if(r == H) continue;
			
			//이전구슬 상태로 배열 복사하여 초기화
			copy(map,copy);
			//터트리기
			hit(copy,r,i);
			//벽돌 내리기
			down(copy);
			//다음 구슬 처리
			if(dfs(k+1, copy)) return true;
	
		}
		return false;
	}
	private static void hit(int[][] map, int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		if(map[r][c]>1) {
			q.add(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.range == 1) continue;
			
			for (int i = 0; i < 4; i++) {
				int nr = p.x;
				int nc = p.y;
				for (int j = 1; j < p.range; j++) {
					nr += dr[i];
					nc += dc[i];
				
					if(nr<0 ||nr>=H||nc<0||nc>=W) {
						continue;
					}
					if(map[nr][nc] == 0) {
						continue;
					}else {
						if(map[nr][nc]>1) {
							q.add(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
					
				}
			}
		}
	}
	private static void down(int[][] map) {
//		for (int c = 0; c < W; c++) {
//			int r = H-1;
//			while(r>0) {
//				if(map[r][c]==0) {
//					int nr = r-1;
//					while(nr>0 && map[nr][c]==0) --nr;
//					map[r][c] = map[nr][c];
//					map[nr][c] = 0;
//				}
//				--r;
//			}
//		}
		for (int c = 0; c < W; c++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int r;
			for (r = H-1; r >= 0; r--){
				if(map[r][c]>0) {
					list.add(map[r][c]);
					map[r][c] = 0;
				}
			}
			r = H;
			for (int  b : list) {
				map[--r][c] = b;
			}
		}
	}
	private static void copy(int[][] map, int[][] copy) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j] > 0)++count;
			}
		}
		return count;
	}

}