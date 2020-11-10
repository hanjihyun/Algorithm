package algorithm_11_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 녹색옷입은애가젤다지_백준4485 {
	static int N,Ans;
	static int[][] map;
	static int[][] v;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우 ,행
	static int[] dc = { 0, 0, -1, 1 }; // 상하좌우,열
	static int num=0;
	static class Point{
		int x,y;

		protected Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			N = sc.nextInt();
			if(N==0) {
				break;
			}
			map=new int[N][N];
			v = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					v[i][j] = 987654321;
				}
			}
			num++;
			//솔루션 구현
			bfs();
			//출력
			Ans = v[N-1][N-1];
			System.out.println("Problem "+ num + ": " + Ans);
		}
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(0, 0));
		v[0][0] = map[0][0];
		while (!q.isEmpty()){
			Point p = q.poll();
			//가지치기 금지!! => 위치만빠르게 오는거지
			//가중치가 있으ㅡ므로  있으면 안된다
			for (int k = 0; k < 4; k++) {
				int nr = p.x + dr[k];
				int nc = p.y + dc[k];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) {
					continue;
				}
				if(v[nr][nc] > map[nr][nc] + v[p.x][p.y]) {
					v[nr][nc] = map[nr][nc] + v[p.x][p.y];
					q.offer(new Point(nr, nc));
				}
			}
		}
	}
}
