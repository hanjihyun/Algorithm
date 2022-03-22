package algorithm_2203;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리_PRo {
	static int answer, R, C;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static boolean[][] v;

	public static void main(String[] args) {
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };
		R = maps.length;
		C = maps[0].length;
		v = new boolean[R][C];

		if (!bfs(maps)) {
			answer = -1;
		}
		System.out.println(answer);
	}

	private static boolean bfs(int[][] maps) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, 0 });
		v[0][0] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			answer++;
			while (--size >= 0) {
				int[] q = queue.poll();

				if (q[0] == R - 1 && q[1] == C - 1)
					return true;

				for (int i = 0; i < 4; i++) {
					int nr = q[0] + dr[i];
					int nc = q[1] + dc[i];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C || v[nr][nc] || maps[nr][nc] == 0)
						continue;

					v[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
		return false;
	}
}
