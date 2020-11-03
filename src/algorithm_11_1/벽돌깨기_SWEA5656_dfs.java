package algorithm_11_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽돌깨기_SWEA5656_dfs {
	static int N,W,H,Ans;
	
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
			int total = 0;
			Ans = Integer.MAX_VALUE;
			
			int sum=0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j <W; j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]>0)total++;
				}
			}
			go(0,total,map);
			System.out.println("#" + test_case + " " + Ans);
		}
	}
	static int bCnt;
	//i번째 구슬을 떨어뜨리기
	private static boolean go(int k,int remainCnt,int[][] map) { // k=던저진 구슬의 개수
		if(remainCnt == 0) {
			Ans = 0;
			return true;
		}
		if(k == N) {
			//남아잇는 벽돌의 개수를 구하여 최소값 갱신
			if(Ans>remainCnt) Ans = remainCnt;
			
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
			bCnt = 0;
			hit(copy,r,i,copy[r][i]);
			//벽돌 내리기
			down(copy);
			//다음 구슬 처리
			if(go(k+1,remainCnt-bCnt, copy)) return true;
	
		}
		return false;
	}
	private static void hit(int[][] map, int r, int c,int cnt) {
		bCnt++;
		
		map[r][c] = 0; // v처리
		if(cnt==1) {
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r;
			int nc = c;
			for (int j = 1; j < cnt; j++) {
				nr += dr[i];
				nc += dc[i];
			
				if(nr<0 ||nr>=H||nc<0||nc>=W||map[nr][nc] == 0) {
					continue;
				}else {
					//v 관리, (부수는 처리, 부순 개수 카운트)
					hit(map,nr, nc, map[nr][nc]);
				}
				
			}
		}
	}
	static ArrayList<Integer> list = new ArrayList<Integer>();
	private static void down(int[][] map) {

		for (int c = 0; c < W; c++) {
			
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
			list.clear();
		}
	}
	private static void copy(int[][] map, int[][] copy) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
}