package algorithm_2103;

import java.util.Scanner;

public class 알파벳_백준1987 {
	static boolean[] alphabet;
	static int R, C, res, max = Integer.MIN_VALUE;
	static int[][] arr;
	static int[] dr = {-1,1,0,0}; //상하좌우
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		res = 1;
		alphabet = new boolean[27];
		arr = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j) - 65;
			}
		}
		
		alphabet[arr[0][0]] = true;
		
		dfs(0,0,1);
		System.out.println(max);
	}
	private static void dfs(int x,int y,int d) {
		if(d > max) {
			max = d;
		}
		if(max == 26) {
			//알파벳 26개 이상 못 봐
			return;
		}
		alphabet[arr[x][y]] = true;
			
		for (int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			
			if (nr < 0 || nr >= R || nc < 0 || nc >= C || alphabet[arr[nr][nc]]) {
				continue;
			}
			if(!alphabet[arr[nr][nc]]) {
				
				dfs(nr, nc,d+1);
			}
			
		}
		alphabet[arr[x][y]] = false;
	}
}
