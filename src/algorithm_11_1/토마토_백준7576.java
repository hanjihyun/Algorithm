package algorithm_11_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_백준7576 {
	static int M,N,day,cnt;
	static int[][] tomato;
	static Queue<Point> q = new LinkedList<Point>();
	static int[][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static class Point{
		int x,y;

		protected Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //가로 
		N = Integer.parseInt(st.nextToken()); //세로
		tomato = new int[N][M];
		v = new int[N][M];
		day = 0;
		cnt=0;
		int notomato=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j]=Integer.parseInt(st.nextToken());
				if(tomato[i][j] == -1){
					v[i][j] = -1;
					notomato++;
				}
				else if(tomato[i][j] == 1) {
					q.add(new Point(i, j));
					v[i][j] = 1;
					cnt++;
				}
			}
		}
		if(cnt == N*M - notomato) {
			System.out.println(0);
			return;
		}
		bfs();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(tomato[i][j]);
//				
//			}
//			System.out.println();
//		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(v[i][j] == 0) {
					System.out.println(-1);
					return;
				}else {
					if(day<tomato[i][j]) {
						day = tomato[i][j];
					}
				}
			}
		}
		System.out.println(day-1);
	}

	private static void bfs() {
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.x+dr[k];
				int nc = p.y+dc[k];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M || v[nr][nc]==1 || tomato[nr][nc]==-1) {
					continue;
				}
				
				if(tomato[nr][nc]==0 && v[nr][nc]==0) {
					tomato[nr][nc] = tomato[p.x][p.y]+ 1;
					q.add(new Point(nr, nc));
					v[nr][nc] = 1;
				}
			}
		}
	}
}
