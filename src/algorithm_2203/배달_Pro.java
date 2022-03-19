package algorithm_2203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 배달_Pro {
	static ArrayList<Point>[] arr;
	static int[] t;
	static boolean[] v;

	static class Point implements Comparable<Point> {
		int n, w;

		protected Point(int n, int w) {
			super();
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}

	}

	public static void main(String[] args) {
		int N = 5;
		int[][] road = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
		int K = 3;
		int answer = 0;

		arr = new ArrayList[N + 1];
		t = new int[N + 1];
		v = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < road.length; i++) {
			arr[road[i][0]].add(new Point(road[i][1], road[i][2]));
			arr[road[i][1]].add(new Point(road[i][0], road[i][2]));

		}
		bfs();

		for (int i = 0; i < N + 1; i++) {
			if (t[i] <= K) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(1, 0));
		Arrays.fill(t, Integer.MAX_VALUE);

		while (!pq.isEmpty()) {
			Point p = pq.poll();
			v[p.n] = true;
			t[p.n] = Math.min(t[p.n], p.w);

			for (Point point : arr[p.n]) {
				if (!v[point.n]) {
					pq.add(new Point(point.n, p.w + point.w));
				}
			}
		}

	}
}
