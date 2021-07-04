package algorithm_2107;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 가장큰수_Pro {
	public static void main(String[] args) {
		int[] numbers = { 0, 0, 0, 0, 0 };

		String answer = "";
		List<Integer> list = new ArrayList<Integer>();
		for (int number : numbers) {
			list.add(Integer.valueOf(number));
		}
		Comparator<Integer> comparator = (o1, o2) -> {
			Integer s1s2 = Integer.valueOf(o1.toString() + o2.toString());
			Integer s2s1 = Integer.valueOf(o2.toString() + o1.toString());
			return s1s2 > s2s1 ? 1 : s1s2.equals(s2s1) ? 0 : -1;
		};
		list.sort(comparator.reversed());
		int cnt = 0;
		for (Integer s : list) {
			answer += String.valueOf(s);
			if(s == 0) {
				cnt++;
			}
		}
		if(cnt==list.size()) {answer="0";}
		System.out.println(answer);
	}
}
