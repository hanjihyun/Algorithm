package algorithm_2201;

import java.util.ArrayList;
import java.util.List;

public class 프렌즈4블록_Pro {
	static char[][] map;
	static int answer = 0;

	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

		map = new char[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}

		while (update(m, n))
			;
		System.out.println(answer);

	}

	private static boolean update(int m, int n) {
		boolean[][] c = new boolean[m][n];
		int cnt = 0;

		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (map[i][j] == '0')
					continue;
				if (check(i, j)) {
					c[i][j] = true;
					c[i][j + 1] = true;
					c[i + 1][j] = true;
					c[i + 1][j + 1] = true;
				}
			}
		}
		// 땡기기
		for (int i = 0; i < n; i++) {
			List<Character> list = new ArrayList<Character>();
			for (int j = m - 1; j >= 0; j--) {
				if (c[j][i]) {
					cnt++;
					continue;
				}
				list.add(map[j][i]);
			}
			for (int j = m - 1, k = 0; j >= 0; j--, k++) {
				if (k < list.size()) {
					map[j][i] = list.get(k);
				} else {
					map[j][i] = '0';
				}
			}
		}
		answer += cnt;
		return cnt > 0 ? true : false;
	}

	private static boolean check(int i, int j) {
		char std = map[i][j];

		if (map[i][j + 1] == std && map[i + 1][j] == std && map[i + 1][j + 1] == std)
			return true;
		return false;

	}
}
