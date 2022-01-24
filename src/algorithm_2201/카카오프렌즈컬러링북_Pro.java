package algorithm_2201;

public class 카카오프렌즈컬러링북_Pro {
	static int numberOfArea = 0;
	static int maxSizeOfOneArea = 0;

	static int cnt = 0;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };

		numberOfArea = 0;
		maxSizeOfOneArea = 0;

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		boolean[][] v = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && !v[i][j]) {
					// 5. 영역의 수가 1개 증가하며 DFS 탐색 수행.
					numberOfArea++;
					dfs(i, j, picture, v);
				}
				if (cnt > maxSizeOfOneArea) {
					maxSizeOfOneArea = cnt;
				}
				cnt = 0;
			}
		}
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	private static void dfs(int x, int y, int[][] picture, boolean[][] v) {
		if (v[x][y])
			return;
		v[x][y] = true;
		cnt++;

		for (int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			if (nr < 0 || nr >= picture.length || nc < 0 || nc >= picture[0].length)
				continue;
			if (picture[x][y] == picture[nr][nc] && !v[nr][nc]) {
				// 12. DFS를 위한 재귀호출.
				dfs(nr, nc, picture, v);
			}
		}
	}
}
