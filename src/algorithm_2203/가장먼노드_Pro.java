package algorithm_2203;

import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드_Pro {
	static boolean[] chk;
	static boolean[][] connect;
	static int answer = 0;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

		chk = new boolean[n];
		connect = new boolean[n][n];

		for (int i = 0; i < edge.length; i++) {
			connect[edge[i][0] - 1][edge[i][1] - 1] = true;
			connect[edge[i][1] - 1][edge[i][0] - 1] = true;
		}
		answer = bfs(n);
		System.out.println(answer);
	}

	private static int bfs(int n) {
		chk[0] = true;
		q.add(0);
		int s = 0;
		while (!q.isEmpty()) {
			s = q.size();
			for (int i = 0; i < s; i++) {
				int node = q.poll();
				for (int j = 1; j < n; j++) {
					if (connect[node][j] && !chk[j]) {
						chk[j] = true;
						q.add(j);
					}
				}
			}
			answer = q.size();
		}
		return s;
	}
}
