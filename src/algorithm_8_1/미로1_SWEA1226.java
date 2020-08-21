package algorithm_8_1;

import java.util.Scanner;

public class 미로1_SWEA1226 {
	static int Ans;
	static int T=0;
	static boolean[][] v;
	static int[][] arr;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			Ans=0;
			T=sc.nextInt();
			
			arr = new int[16][16];
			v = new boolean[16][16];
			
			for (int i = 0; i < 16; i++) {
				String str = sc.next();
				for (int j = 0; j < 16; j++) {
					arr[i][j] = str.charAt(j)-'0';
				}
			}
			
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					if(arr[i][j] == 2) {
						dfs(i,j);
//						if(arr[i][j] == 3) {
//							Ans=1;
//							return;
//						}
					}	
				}
			}
			
			
			System.out.println("#"+T+" "+ Ans);
		}
	}

	private static void dfs(int i, int j) {
		v[i][j] = true;
		
		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			
			if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && !v[nr][nc] && arr[nr][nc] == 0) {
				dfs(nr, nc);
			}
			if(arr[nr][nc] == 3) {
				Ans = 1;
				return;
			}
		}
	}

}
