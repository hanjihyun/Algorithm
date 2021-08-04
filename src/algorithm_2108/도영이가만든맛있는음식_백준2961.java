package algorithm_2108;

import java.util.ArrayList;
import java.util.Scanner;

public class 도영이가만든맛있는음식_백준2961 {
	static ArrayList<Point> arr = new ArrayList<Point>();
	static int len;
	static boolean[] sel;
	static int min = Integer.MAX_VALUE;;

	static class Point {
		int s, b;

		protected Point(int s, int b) {
			super();
			this.s = s;
			this.b = b;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int S = Math.abs(sc.nextInt());
			int B = Math.abs(sc.nextInt());
			arr.add(new Point(S, B));
		}
		len = arr.size();
		sel = new boolean[len];
		powerSet(0);
		System.out.println(min);
	}

	private static void powerSet(int idx) {
		if (idx == len) {
			int S = 1;
			int B = 0;
			int cnt = 0;
			for (int i = 0; i < len; i++) {
				if (sel[i] == true) {
//					System.out.print(arr.get(i).s + " "+arr.get(i).b);
					cnt++;
					S *= arr.get(i).s;
					B += arr.get(i).b;
				}
//				System.out.println("Math.abs(S-B)" + Math.abs(S - B));
				
			}
			if(cnt == 0) return;
			if (min > Math.abs(S - B)) {
				min = Math.abs(S - B);
			}
			return;
		}
		sel[idx] = true;
		powerSet(idx + 1);

		sel[idx] = false;
		powerSet(idx + 1);

	}
}
