package algorithm_HW;

import java.util.Scanner;

public class 해밀턴순환회로_정올1681 {
	static int N, min;
	static int[][] map;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		v = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		min = Integer.MAX_VALUE;
	
		dfs(1, 1, 0);
		System.out.println(min);
	}

	private static void dfs(int current, int len, int total) {

		if (total > min) {
			return;
		}
		if (len == N && map[current][1] != 0) {
			if (min > map[current][1] + total) {
				min = map[current][1] + total;
				return;
			}
		}

		for (int i = 2; i <= N; ++i) {
			if(i == current) continue;
			if (!v[i] && map[current][i] != 0) {
				v[i] = true;
			
				dfs(i, len + 1, total + map[current][i]);
				v[i] = false;
			}
		}
	}

}
