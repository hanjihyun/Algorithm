package algorithm_2101;

import java.util.Scanner;

public class 그림_백준1926 {
	static int[][] paper;
	static int N,M,cnt,max,count;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] v; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		paper = new int[N][M];
		v = new boolean[N][M];
		
		max = 0;
		count =0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(paper[i][j] == 1 && !v[i][j]) {
					cnt = 1;
					dfs(i,j);
					max = Integer.max(max, cnt);
					count++;
				}
				
			}
		}
		System.out.println(count);
		System.out.println(max);
	}
	private static void dfs(int x, int y) {
		
		v[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nr = x + dr[d];
			int nc = y + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M || v[nr][nc]) {
				continue;
			}
			if(paper[nr][nc] == 1 && !v[nr][nc]) {
				cnt++;
				dfs(nr,nc);
			}

		}
		
	}
}
