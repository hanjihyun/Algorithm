package algorithm_IM_Review2;

import java.util.Scanner;

public class 자리배정_백준10157 {
	static int R, C, K;
	static int map[][];
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		K = sc.nextInt();
		map = new int[R][C];
		
		if (C * R < K) {
			System.out.println(0);
			return;
		}
		 int cnt = 1;
	      int r = R - 1;
	      int c = 0;
	      int dir = 0;

		while(cnt!=K) {
			map[r][c] = cnt++;
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			  if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) {
				  r = nr;
				  c= nc;
			  }else {
				  dir++;
				  if(dir==4) {
					  dir=0;
				  }
				  r = r+dr[dir];
				  c = c+dc[dir];
			  }
		}
		System.out.println((c+1)+" "+(R-r));
	}
}
