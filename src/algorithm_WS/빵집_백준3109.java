package algorithm_WS;

import java.util.Scanner;

public class 빵집_백준3109 {
	static int R, C, Ans;
	static char[][] gas;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1 };
	static int[] dc = { 1, 1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		gas = new char[R][C];
		v = new boolean[R][C];
		Ans = 0;

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				gas[i][j] = str.charAt(j);
				if (gas[i][j] == 'x') {
					v[i][j] = true;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			if (!v[i][0]) {
				connect(i, 0);
				Ans++;
			}
		}
		System.out.println(Ans);

	}

	private static void connect(int x, int y) {
		v[x][y] = true;
		for (int k= 0; k < 3; k++) {
			int nr = x + dr[k];
			int nc = y + dc[k];
			
			if(nr<0 || nr>=R || nc <0 || nc>=C) {
				continue;
			}
			if(check()) {
				
			}
			if(!v[nr][nc] && gas[nr][nc] != 'x') {
				
			}
		}
	}

	private static boolean check() {
		// TODO Auto-generated method stub
		return false;
	}
}
