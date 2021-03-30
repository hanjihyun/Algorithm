package algorithm_2103;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그대그머가되어_백준14496 {
	static int a, b, N, M, Ans;
	static List<Point> list;

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
		list = new ArrayList<>();
		int aCnt = 0;
		Ans = 0;
		for (int i = 0; i < M; i++) {
			int ix = sc.nextInt();
			int iy = sc.nextInt();

			list.add(new Point(ix, iy));
		}
		int cnt = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			if (list.get(i).x == a) {
				aCnt++;
				check(i, a);
			}
		}

		System.out.println(Ans);
	}

	private static void check(int i,int ia) {
		for (int j = i; j < M; j++) {
			
			Point p = list.get(j);
			if(p.x == ia) {
			ia = p.y;
//			if (.y == b) {
//				
//			}
			}
		}
	}

}
//while (aCnt <= 0) {
//	for (int i = 0; i < M; i++) {
//		if (list.get(i).x == a) {
//			cnt++;
//			a = list.get(i).y;
//			if (list.get(i).y == b) {
//				if(cnt<=min) {
//					min = cnt;
//					
//				}
//			}
//		}
//	}
//}