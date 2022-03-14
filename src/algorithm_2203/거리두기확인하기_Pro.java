package algorithm_2203;

import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기_Pro {
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		int[] answer = new int[places.length];

		for (int i = 0; i < places.length; i++) {
			String[] p = places[i];

			boolean chk = true;
			for (int r = 0; r < 5 && chk; r++) {
				for (int c = 0; c < 5 && chk; c++) {
					if (p[r].charAt(c) == 'P') {
						if (!bfs(r, c, p))
							chk = false;
					}
				}
			}
			answer[i] = chk ? 1 : 0;
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	private static boolean bfs(int r, int c, String[] p) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] position = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = position[0] + dr[i];
				int nc = position[1] + dc[i];

				if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == r && nc == c))
					continue;

				int d = Math.abs(nr - r) + Math.abs(nc - c);

				if (p[nr].charAt(nc) == 'P' && d <= 2)
					return false;
				else if (p[nr].charAt(nc) == 'O' && d < 2)
					q.offer(new int[] { nr, nc });
			}
		}

		return true;
	}

}
