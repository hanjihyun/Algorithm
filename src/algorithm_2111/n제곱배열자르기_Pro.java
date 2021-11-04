package algorithm_2111;

import java.util.ArrayList;
import java.util.List;

public class n제곱배열자르기_Pro {
	static List<Long> list = new ArrayList<>();
	public static void main(String[] args) {
		int n = 3;
		long left = 2;
		long right = 5;
		long[] answer = new long[(int) (right-left + 1)];

		for (long i = left; i <= right; i++) {
			list.add(Math.max(i/n, i%n)+1);
		}
		
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
	}
}
