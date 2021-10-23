package algorithm_2110;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 창고다각형_백준2304 {
	static int N;
	static int[] arr;
	static List<Point> list = new ArrayList<Point>();

	static class Point implements Comparable<Point> {
		int l, h;

		Point(int l,int h) {
			super();
			this.l = l;
			this.h = h;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.l - o.l;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[1001];
		
		for (int i = 0; i < N; i++) {
			int L = sc.nextInt();
			int H = sc.nextInt();
			list.add(new Point(L,  H));
		}

		Collections.sort(list);
		Point start = list.get(0);
		int tall = 0;
		int area = 0;
		for (int i = 1; i < N; i++) {
			Point cur = list.get(i);
			if (start.h <= cur.h) {
				area += (cur.l - start.l) * start.h;

				start = cur;
				tall = i;
			}
		}
		start = list.get(list.size() - 1);
		for (int i = 1; i < list.size() - tall; i++) {
			Point cur = list.get(list.size() - i - 1);
			if (start.h <= cur.h) {
				int width = start.l - cur.l;
				area += width * start.h;
				start = cur;
			}
		}
		area += start.h;
		System.out.println(area);
	}
}
