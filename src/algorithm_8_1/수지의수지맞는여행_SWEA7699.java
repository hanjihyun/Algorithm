package algorithm_8_1;

import java.util.Scanner;

public class 수지의수지맞는여행_SWEA7699 {
	static int R, C, max;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			R = sc.nextInt();
			C = sc.nextInt();
			map = new int[R][C];
			v = new boolean[26];

			max = 0;
			for (int i = 0; i < R; i++) {
				String path = sc.next();
				for (int j = 0; j < C; j++) {
					map[i][j] = path.charAt(j)-'A';
				}
			}
			
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}

			dfs(0, 0, 1);

			System.out.println("#" + test_case + " " + max);
		}
	}

	private static void dfs(int x, int y, int depth) {
		if(max<depth) {
			max = depth;
		}
		if(max == 26) {
			//알파벳 26개 이상 못 봐
			return;
		}
		
		v[map[x][y]] = true;
		
		for (int k = 0; k < 4; k++) {
			int nr = x + dr[k];
			int nc = y + dc[k];
			
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !v[map[nr][nc]]) {
				dfs(nr, nc, depth+1);
			}

		}
		v[map[x][y]] = false; //다시 방문 할 수 있게
	}
}
