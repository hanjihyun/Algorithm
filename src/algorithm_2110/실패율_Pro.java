package algorithm_2110;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 실패율_Pro {
	static List<Point> list;

	static class Point {
		double perc;
		int idx;

		Point(double perc, int idx) {
			super();
			this.perc = perc;
			this.idx = idx;
		}
	}

	public static void main(String[] args) {
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		int[] answer = new int[N];
		list = new ArrayList<Point>();
		int[] arr = new int[N + 1];

		int person = stages.length;

		for (int i = 0; i < stages.length; i++) {
			arr[stages[i] - 1]++;
		}

		for (int i = 0; i < N; i++) {

			if (arr[i] == 0) {
				list.add(new Point(0, i));
			} else {
				list.add(new Point((double) arr[i] / person, i));
			}
//			System.out.println(arr[i] + " / " + (person) + " = " + ((double) arr[i] / person));
			person -= arr[i];

		}
		Collections.sort(list, ((o1, o2) -> Double.compare(o2.perc, o1.perc)));

		for (int i = 0; i < answer.length; i++) {

			answer[i] = list.get(i).idx + 1;

		}

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
