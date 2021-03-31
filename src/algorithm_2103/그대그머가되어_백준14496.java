package algorithm_2103;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 그대그머가되어_백준14496 {
	static int a, b, N, M, Ans;
	static List<Integer> list[] = new ArrayList[1001];
	static int[] dist;
	static class Point {
		int x, y;

		protected Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		
		dist = new int[1001];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
			dist[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < M; i++) {
			int ix = sc.nextInt();
			int iy = sc.nextInt();

			list[ix].add(iy);
			list[iy].add(ix);
		}

		bfs(a);

		System.out.println(dist[a] == Integer.MAX_VALUE ? -1 : dist[b]);
	}

	private static void bfs(int ia) {
		Queue<Point> q = new PriorityQueue<>((a,b)->a.y - b.y);
		dist[ia] = 0;
		q.add(new Point(ia, 0));
		
		while(!q.isEmpty()) {
		
			Point p = q.poll();
			int cur = p.x;
			int d = p.y;
			
			if(dist[cur] < d) continue;
			for (int i:list[cur]) {
				if(dist[i]>d+1){
					dist[i] = d+1;
					q.add(new Point(i, d+1));
				}
			}
		}
	}

}