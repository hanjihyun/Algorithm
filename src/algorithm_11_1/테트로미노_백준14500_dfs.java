package algorithm_11_1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class 테트로미노_백준14500_dfs {
	static int N,M,Ans;
	static int[][] map;
	static boolean[][] v;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(j,i,0,0);
				other(j,i);
			}
		}
		System.out.println(Ans);
	}
	private static void other(int x,int y) {
		int sum =map[y][x];
		int min = Integer.MAX_VALUE;
		int check = 4;
		for (int d = 0; d < 4; d++) {
			if(check <= 2) {return;}
			int nx = x+dx[d]; 
			int ny = y+dy[d];
			if(nx<0 ||nx>=M||ny<0||ny>=N) {
				check--;
				continue;
			}
			min = Math.min(min, map[ny][nx]);
			sum+=map[ny][nx];
		}
		if(check == 4) {
			sum -= min;
		}
		Ans = Math.max(Ans, sum);
	}
	private static void dfs(int x,int y,int dep,int sum) {
		
		if(dep == 4) {
			Ans = Math.max(Ans, sum);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d]; 
			int ny = y+dy[d];
			if(nx<0 ||nx>=M||ny<0||ny>=N||v[ny][nx]) {
				
				continue;
			}
			v[ny][nx] = true;
			dfs(nx,ny,dep+1,sum+map[ny][nx]);
			v[ny][nx] = false;
			
		}
		
		
	}
}
