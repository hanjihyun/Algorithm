package algorithm_2110;

import java.util.Scanner;

public class 알파벳_백준 {
	static int R, C,Ans = Integer.MIN_VALUE,d;
	static char[][] alph;
	static boolean[] alphChk;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		alph = new char[R][C];
		alphChk = new boolean[27];
	
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				alph[i][j] = str.charAt(j);
			}
		}
		
		dfs(0,0,1);
		
		System.out.println(Ans);
	}

	private static void dfs(int i, int j,int d) {
		if(d > Ans) {
			Ans = d;
		}
		if(Ans >= 26) {
			return;
		}
		alphChk[alph[i][j]-65] = true;
	
		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			
			if(nr<0||nr>=R||nc<0||nc>=C||alphChk[alph[nr][nc]-65]) {
				continue;
			}
		
			if(!alphChk[alph[nr][nc] - 65]) {
			
				dfs(nr, nc,d+1);
			}
		}
		alphChk[alph[i][j]-65] = false;
	}
}
