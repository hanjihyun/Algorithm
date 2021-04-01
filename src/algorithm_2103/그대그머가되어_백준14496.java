package algorithm_2103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 그대그머가되어_백준14496 {
	static int a, b, N, M, Ans;
	static List<Point> list[];
	static boolean v[];
	static class Point {
		int y, cnt;

		protected Point(int y, int cnt) {
			super();
			this.y = y;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt()-1;
		b = sc.nextInt()-1;
		N = sc.nextInt();
		M = sc.nextInt();
		list= new ArrayList[N];
		Ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList();
		}
		for (int i = 0; i < M; i++) {
			int ix = sc.nextInt()-1;
			int iy = sc.nextInt()-1;

			list[ix].add(new Point(iy, 0));
			list[iy].add(new Point(ix,0));
		}

		Queue<Point> q = new LinkedList();
		q.add(new Point(a, 0));
		v = new boolean[N];
		 v[a] = true;
		while(!q.isEmpty()) {
		
			Point p = q.poll();
		
			 if (p.y == b) {
				 Ans = Math.min(Ans, p.cnt);
	            }
			 int size = list[p.y].size();
			 for (int j = 0; j < size; j++) { 
				 Integer n = list[p.y].get(j).y;
				 if (!v[n]) {
	                    v[n] = true;
	                    q.add(new Point(n, p.cnt + 1));
	                }

			}
		}

		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);
	}
}