package algorithm_HW;

import java.util.Scanner;

public class 알파벳_백준1987 {
	static int R, C, max;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		v = new boolean[26];

		max = 0;
		
		for (int i = 0; i < R; i++) {
			String path = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = path.charAt(j);
			}
		}
		
		dfs(0,0,1);
		System.out.println(max);
	}
	
	private static void dfs(int x, int y, int dep) {
		if(max<dep) {
			max = dep;
		}
		if(max == 26) {
			//알파벳 26개 이상 못 봐
			return;
		}
		v[map[x][y]-'A'] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !v[map[nr][nc]-'A']) {
				dfs(nr, nc, dep+1);
			}
			
			
		}
		v[map[x][y]-'A'] = false;
	}

}
